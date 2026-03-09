package com.idlogix.process;

import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.adempiere.exceptions.AdempiereException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.idlogix.model.MSAPFBRCredential;
import com.idlogix.model.MSAPInvoice;

@org.adempiere.base.annotation.Process
public class PostInvoiceOnFBR extends SvrProcess {
	MSAPFBRCredential cred;
//	MSAPFBRCredential cred = new Query(getCtx(), MSAPFBRCredential.Table_Name, "isActive = 'Y' and ad_client_id = ? ", get_TrxName())
//	    .setOrderBy("created DESC").setParameters(getAD_Client_ID())
//	    .first();
//	MSAPFBRCredential cred = new Query(getCtx(), MSAPFBRCredential.Table_Name, "isActive = 'Y' and ad_client_id = ? ", get_TrxName())
//		    .setOrderBy("created DESC")
//		    .setParameters(Env.getAD_Client_ID(getCtx()))
//		    .first();
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
		cred = new Query(getCtx(), MSAPFBRCredential.Table_Name, "isActive = 'Y' and ad_client_id = ? ", get_TrxName())
			    .setOrderBy("created DESC")
			    .setParameters(Env.getAD_Client_ID(getCtx()))
			    .first();
		
	}

	@Override
	protected String doIt() throws Exception {
		 List<MSAPInvoice> invoices = getSelectedInvoices();
		    for (MSAPInvoice invoice : invoices) {
		        validateInvoice(invoice);
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
	void validateInvoice(MSAPInvoice invoice) {
			
        String apiUrl = cred.getfbr_api_url();
        String bearerToken = cred.getfbr_bearer_token();
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(apiUrl);
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Accept", "application/json");
            post.setHeader("Authorization", "Bearer " + bearerToken);           
            post.setEntity(new StringEntity(invoice.getFBRJsonPayload(cred), StandardCharsets.UTF_8));                     
//            System.out.println(invoice.getFBRJsonPayload());           
            try (CloseableHttpResponse response = httpClient.execute(post)) {
                int statusCode = response.getStatusLine().getStatusCode();
                String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                if (statusCode >= 200 && statusCode < 300) {
                    // Extract invoiceNumber from JSON
                    ObjectMapper map = new ObjectMapper();
                    JsonNode root = map.readTree(responseBody);
                    String invoiceNumber = root.path("invoiceNumber").asText();
                    JsonNode validation = root.path("validationResponse");
                    String responseStatus = validation.path("status").asText();
                    String error = validation.path("error").asText();
                    if ("Valid".equals(responseStatus)) {                  	
                    	invoice.setfbr_invoice_no(invoiceNumber);
                    	invoice.setIsValid(true);
                    	invoice.setfbr_error_msg(responseBody);
                    	invoice.saveEx();
                    	System.out.println("Sent to FBR: " + invoiceNumber);
                    }
                    else {
                        System.out.println(responseBody);

                        ObjectMapper mapper = new ObjectMapper();
                        ObjectNode errorRoot = mapper.createObjectNode();

                        errorRoot.put("invoiceStatus", responseStatus);

                        // Header-level error
                        if (error != null && !error.trim().isEmpty()) {
                            errorRoot.put("headerError", error);
                        } else {
                            errorRoot.put("headerError", "");
                        }

                        // Line-level errors
                        ArrayNode lineErrors = mapper.createArrayNode();
                        JsonNode statuses = validation.path("invoiceStatuses");

                        if (statuses.isArray()) {
                            for (JsonNode statusNode : statuses) {
                                String itemError = statusNode.path("error").asText();
                                if (itemError != null && !itemError.trim().isEmpty()) {
                                    ObjectNode lineError = mapper.createObjectNode();
                                    lineError.put("itemSNo", statusNode.path("itemSNo").asText());
                                    lineError.put("error", itemError);
                                    lineErrors.add(lineError);
                                }
                            }
                        }

                        // Only add lineErrors if at least one exists
                        if (lineErrors.size() > 0) {
                            errorRoot.set("lineErrors", lineErrors);
                        }

                        invoice.setIsValid(false);
                        invoice.setfbr_error_msg(errorRoot.toString());
                        invoice.saveEx();
                    }

                } 
                else {
                	invoice.setIsValid(false);
                	invoice.setfbr_error_msg(responseBody);
                	invoice.saveEx();                    
                }
               
            }
            catch (Exception e) {
		        e.printStackTrace();
		    }
        }
        catch (Exception e) {
	        e.printStackTrace();
	    }
		
		
	}
	

}
