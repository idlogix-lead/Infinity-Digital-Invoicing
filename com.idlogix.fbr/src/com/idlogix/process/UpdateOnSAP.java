package com.idlogix.process;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

import com.idlogix.model.MSAPFBRCredential;
import com.idlogix.model.MSAPInvoice;

@org.adempiere.base.annotation.Process
public class UpdateOnSAP extends SvrProcess {
	MSAPFBRCredential cred;
	int org_id;
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (name.equals("AD_Org_ID"))
				org_id = para[i].getParameterAsInt();
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
			
		}
	}

	@Override
	protected String doIt() throws Exception {
		
		cred= new Query(getCtx(), MSAPFBRCredential.Table_Name, " ad_org_id = ? and isActive = 'Y'", get_TrxName()).setParameters(org_id)				
			    .setOrderBy("created DESC")
			    .first();
		
		
		 List<MSAPInvoice> invoices = getSelectedInvoices();
		    for (MSAPInvoice invoice : invoices) {
		    	String docentry = invoice.getdoc_entry_no();
		    	int docEntry = Integer.parseInt(docentry);
		    	Boolean isvalid = invoice.isValid();
		    	String fbr_ref_no = invoice.getfbr_invoice_no();	
		    	 if (fbr_ref_no == null || fbr_ref_no.trim().isEmpty() || !isvalid) {
		             continue;
		         }
//		    	 int fbrRefNo = Integer.parseInt(fbr_ref_no);
		    	updateSAPInvoice(docEntry,fbr_ref_no,invoice);
		    }
		    
		    return null;
//		
	}
	List<MSAPInvoice>  getSelectedInvoices(){
		 List<Integer> ids = new ArrayList<Integer>();
		 String sql = "select * from t_selection where t_selection.ad_pinstance_id = ?";
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 try
			{
			pstmt = DB.prepareStatement(sql.toString(), get_TrxName());
			pstmt.setInt(1, getAD_PInstance_ID());
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				int T_Selection_ID = rs.getInt("T_Selection_ID");				
				ids.add(T_Selection_ID);
			}
		}
		catch (Exception e)
		{
			throw new AdempiereException(e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		  String filter  = MSAPInvoice.COLUMNNAME_SAP_Invoice_ID +" IN (" +
						  ids.stream()
		                 .map(String::valueOf)
		                 .collect(Collectors.joining(","))
		 				  +")";
		  
		  return new Query(getCtx(), MSAPInvoice.Table_Name, filter, get_TrxName()).list();
	 }
	public String updateSAPInvoice(int docEntry ,String fbrInvoiceNo,MSAPInvoice invoice) {
	    try {
	        String url = "https://uactros.myinfinitycrms.com/api/sap-bridge-update";
	        String invoiceUrl = String.format("%sInvoices(%d)", cred.getsap_invoice_url(), docEntry);

	        String payload = String.format("""
	        		{
	        		    "loginUrl": "%s",
	        		    "invoiceUrl": "%s",
	        		    "loginPayload": {
	        		        "UserName": "%s",
	        		        "Password": "%s",
	        		        "CompanyDB": "%s"
	        		    },
	        		    "invoiceUpdateData": {
	        		        "U_FBRINV": "%s"
	        		    }
	        		}
	        		""",
	        		    cred.getsap_login_url(),
	        		    invoiceUrl,
	        		    cred.getsap_username(),
	        		    cred.getsap_password(),
	        		    cred.getsap_company_db(),
	        		    fbrInvoiceNo  // This is your new address or updated value
	        		);

//	        String payload = """
//	        {
//	            "loginUrl": "https://103.48.1.86:50000/b1s/v1/Login",
//	            "invoiceUrl": "https://103.48.1.86:50000/b1s/v1/Invoices(%d)",
//	            "loginPayload": {
//	                "UserName": "manager",
//	                "Password": "Admin@123",
//	                "CompanyDB": "TEST"
//	            },
//	            "invoiceUpdateData": {
//	                 "Address": %d
//	            }
//	        }
//	        """.formatted(docEntry, fbrInvoiceNo); // Inject docEntry dynamically

	        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	            HttpPatch patch = new HttpPatch(url);
	            patch.setHeader("Content-Type", "application/json");
	            patch.setEntity(new StringEntity(payload, StandardCharsets.UTF_8));

	            try (CloseableHttpResponse response = httpClient.execute(patch)) {
	                int statusCode = response.getStatusLine().getStatusCode();
	                String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
	                if(statusCode==200)
	                	invoice.setisSAPUpdated(true);
	                	invoice.saveEx();
	                	System.out.println("Laravel Response (Status " + statusCode + "):");
	                	System.out.println(responseBody);
	                return responseBody;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error during SAP PATCH API communication: " + e.getMessage();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error during Api communication: " + e.getMessage();
	    }
	}
	

}
