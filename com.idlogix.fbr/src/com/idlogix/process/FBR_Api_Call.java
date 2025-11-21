    package com.idlogix.process;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idlogix.model.MSAPFBRCredential;
import com.idlogix.model.MSAPInvoice;
import com.idlogix.model.MSAPInvoiceLine;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import org.adempiere.base.annotation.Process;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;

@Process
public class FBR_Api_Call extends SvrProcess {
   MSAPFBRCredential cred;
   Timestamp p_startdate;
   Timestamp p_enddate;
   int org_id;
   String docNum;

   protected void prepare() {
      ProcessInfoParameter[] para = this.getParameter();

      for(int i = 0; i < para.length; ++i) {
         String name = para[i].getParameterName();
         if (para[i].getParameter() != null) {
            if (name.equals("StartDate")) {
               this.p_startdate = para[i].getParameterAsTimestamp();
            } else if (name.equals("EndDate")) {
               this.p_enddate = para[i].getParameterAsTimestamp();
            } else if (name.equals("AD_Org_ID")) {
               this.org_id = para[i].getParameterAsInt();
            } else if (name.equals("DocNum")) {
                this.docNum = para[i].getParameterAsString();
            } else {
               this.log.log(Level.SEVERE, "Unknown Parameter: " + name);
            }
         }
      }

   }

   protected String doIt() throws Exception {
	   cred= new Query(getCtx(), MSAPFBRCredential.Table_Name, " ad_org_id = ?  and isActive = 'Y'", get_TrxName()).setParameters(org_id)				
			    .setOrderBy("created DESC")
			    .first();      
	   if (this.cred == null) {
         return "No Credentials found for this organization!";
      } else {
         String invoiceJson = this.fetchSAPInvoices();
         ObjectMapper jsonmapper = new ObjectMapper();
         JsonNode rootNode = jsonmapper.readTree(invoiceJson);
         Map<Integer, MSAPInvoice> invoiceMap = new LinkedHashMap();
         Set<String> existingDocEntries = this.getExistingInvoices();
         Iterator var7 = rootNode.path("invoices").iterator();

         while(true) {
            while(var7.hasNext()) {
               JsonNode row = (JsonNode)var7.next();
               JsonNode invoiceNode = row.path("Invoices");
               JsonNode lineNode = row.path("Invoices/DocumentLines");
               JsonNode itemNode = row.path("Items");
               JsonNode BPartnersNode = row.path("BusinessPartners");
               int docEntry = invoiceNode.path("DocEntry").asInt();
               int docNum = invoiceNode.path("DocNum").asInt();
               MSAPInvoice invoice;
               String buyerNtnCnic;
               String U_RegType;
               if (!invoiceMap.containsKey(docEntry)) {
                  if (existingDocEntries.contains(String.valueOf(docEntry))) {
                     System.out.println("Updating existing invoice DocEntry: " + docEntry);
//                     invoice = new MSAPInvoice(getCtx(), docEntry, get_TrxName());
//                     invoice = new MSAPInvoice(getCtx(), null, U_RegType);
                     invoice = (MSAPInvoice)(new Query(this.getCtx(), "SAP_Invoice", "doc_entry_no = ? and ad_client_id = ? AND ad_org_id = ?", this.get_TrxName())).setParameters(String.valueOf(docEntry), this.getAD_Client_ID(), this.org_id).first();
//                     invoice = new Query(getCtx(), MSAPInvoice.Table_Name, " ad_org_id = ? and isActive = 'Y'", get_TrxName()).setParameters(org_id)				
//           			    .setOrderBy("created DESC")
//           			    .first();      
                     if (invoice != null && invoice.isValid()) {
                        System.out.println("Skipping DocEntry " + docEntry + " because is_valid = true");
                        continue;
                     }
                  } else {
                     invoice = new MSAPInvoice(this.getCtx(), 0, this.get_TrxName());
                  }

                  invoice.setAD_Org_ID(this.org_id);
                  invoice.setdoc_entry_no(String.valueOf(docEntry));
                  invoice.setDocumentNo(String.valueOf(docNum));
                  invoice.setinvoice_type("Sale Invoice");
                  String cardName = invoiceNode.path("CardName").asText((String)null);
                  String buyerAddress = BPartnersNode.path("Address").asText((String)null);
                  String docDate = invoiceNode.path("DocDate").asText((String)null);
                  BigDecimal var10000 = BigDecimal.ZERO;
                  buyerNtnCnic = BPartnersNode.path("FederalTaxID").asText((String)null);
                  String buyerCnic = BPartnersNode.path("AdditonalID").asText((String)null);
                  U_RegType = BPartnersNode.path("U_RegType").asText((String)null);
                  invoice.setinvoice_date(Timestamp.valueOf(docDate + " 00:00:00"));
                  invoice.setbuyer_business_name(cardName != null ? cardName : "Unknown");
                  invoice.setseller_business_name(this.cred.getseller_business_name());
                  invoice.setseller_province(this.cred.getseller_province());
                  invoice.setseller_address(this.cred.getseller_address());
                  invoice.setseller_ntn_cnic(this.cred.getseller_ntn_cnic());
                  invoice.setbuyer_province("PUNJAB");
                  invoice.setbuyer_address(buyerAddress != null ? buyerAddress : "N/A");
                  invoice.setprovince_code("7");
                  invoice.setcity_code("0301");
                  invoice.setAddress("123 Main Market");
                  if ("Registered".equals(U_RegType)) {
                     invoice.setscenario_id("SN001");
                     invoice.setbuyer_registration_type("Registered");
                     invoice.setbuyer_ntn_cnic(buyerNtnCnic);
                  } else {
                     invoice.setscenario_id("SN002");
                     invoice.setbuyer_registration_type("Unregistered");
                     invoice.setbuyer_ntn_cnic(buyerCnic);
                  }

                  invoice.saveEx();
                  invoiceMap.put(docEntry, invoice);
               } else {
                  invoice = (MSAPInvoice)invoiceMap.get(docEntry);
               }

               MSAPInvoiceLine line = new Query(this.getCtx(), "SAP_Invoiceline", "sap_invoice_id = ? AND ad_client_id = ? AND ad_org_id = ? and product_description = '"+lineNode.path("ItemDescription").asText("")+"'", this.get_TrxName()).setParameters(invoice.get_ID(), this.getAD_Client_ID(), this.org_id).first();
               if (line == null) {
                  line = new MSAPInvoiceLine(this.getCtx(), 0, this.get_TrxName());
               }

               line.setSAP_Invoice_ID(invoice.get_ID());
               line.setproduct_description(lineNode.path("ItemDescription").asText(""));
               BigDecimal qty = new BigDecimal(lineNode.path("Quantity").asText("0"));
               BigDecimal weight = new BigDecimal(itemNode.path("U_Weight").asText("0"));
               line.setquantity(qty.multiply(weight));
               line.setRate("18%");
               line.seths_code(itemNode.path("U_HSCode").asText(""));
               buyerNtnCnic = "KG";
               line.setuom(buyerNtnCnic);
               BigDecimal ex_totalBigDecimal = new BigDecimal(lineNode.path("LineTotal").asText("0"));
               line.setvalue_sales_excluding_st(ex_totalBigDecimal);
               String baseurl = this.cred.getsap_invoice_url();
               
//               String taxTotal = null;
             
               BigDecimal t_totalBigDecimal ;
               Map<String, String> taxResult = this.GetTaxTotal(lineNode, docEntry, baseurl);
               
               if (!lineNode.path("TaxTotal").isNull() && !"0".equals(lineNode.path("TaxTotal").asText())) {
//                   taxTotal = lineNode.path("TaxTotal").asText();
                   t_totalBigDecimal = new BigDecimal(lineNode.path("TaxTotal").asText());
                   line.setsales_tax_applicable(t_totalBigDecimal);

               } else {
                   t_totalBigDecimal = new BigDecimal((String)taxResult.get("gst_tax"));
                    
                    line.setsales_tax_applicable(t_totalBigDecimal);
                }
               line.setfixed_notified_value_or_retail_price(BigDecimal.ZERO);
               line.setsales_tax_withheld_at_source(BigDecimal.ZERO);
               line.setextra_tax(new BigDecimal((String)taxResult.get("additional_tax")));
               line.setfurther_tax(new BigDecimal((String)taxResult.get("further_tax")));
               BigDecimal totalAllTax = t_totalBigDecimal.add( new BigDecimal((String)taxResult.get("further_tax"))
            		   .add(new BigDecimal((String)taxResult.get("additional_tax")))); 
               line.settotal_values(totalAllTax.add(ex_totalBigDecimal));

               line.setsro_schedule_no("");
               line.setfed_payable(BigDecimal.ZERO);
               line.setDiscount(new BigDecimal(lineNode.path("DiscountPercent").asText("0")));
               line.setsale_type("Goods at standard rate (default)");
               line.setsro_item_serial_no("");
               line.setAD_Org_ID(this.org_id);
               line.setsupply_destination("");
               line.saveEx();
//              saving total in InvoiceHeader
            // Recalculate total for this invoice
//               BigDecimal invoiceTotal = DB.getSQLValueBD(
//                   get_TrxName(),
//                   "SELECT COALESCE(SUM(total_values), 0) FROM SAP_Invoiceline WHERE sap_invoice_id = ?",
//                   invoice.get_ID()
//               );
//               invoice.setTotalAmt(invoiceTotal);
//               invoice.saveEx();
            }
            
            return "Invoices processed: " + invoiceMap.size();
         }
      }
   }

   public String fetchSAPInvoices() {
      try {
         String url = "https://uactros.myinfinitycrms.com/api/sap-bridge-get";
         String baseUrl = this.cred.getsap_invoice_url();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//         String startDateStr = sdf.format(this.p_startdate);
//         String endDateStr = sdf.format(this.p_enddate);
      // Always required filters
         List<String> conditions = new ArrayList<>();
         conditions.add("Invoices/DocEntry eq Invoices/DocumentLines/DocEntry");
         conditions.add("Invoices/DocumentLines/ItemCode eq Items/ItemCode");
         conditions.add("Invoices/CardCode eq BusinessPartners/CardCode");

         if (docNum != null && !docNum.trim().isEmpty()) {
             // If DocNum is present → only filter by DocNum
             conditions.add(String.format("Invoices/DocNum eq '%s'", docNum));
         } else {
        	 String startDateStr = sdf.format(this.p_startdate);
             String endDateStr = sdf.format(this.p_enddate);
             // If DocNum not present → filter by date range (mandatory)
             if (startDateStr == null || endDateStr == null || 
                 startDateStr.trim().isEmpty() || endDateStr.trim().isEmpty()) {
                 throw new IllegalArgumentException("StartDate and EndDate are required when DocNum is not provided.");
             }

             conditions.add(String.format("DocDate ge '%s'", startDateStr));
             conditions.add(String.format("DocDate le '%s'", endDateStr));
         }

         // Join all conditions with "and"
         String filter = String.join(" and ", conditions);
//         String filter = String.format(Invoices/DocEntry eq Invoices/DocumentLines/DocEntry and Invoices/DocumentLines/ItemCode eq Items/ItemCode and Invoices/CardCode eq BusinessPartners/CardCode and DocDate ge '%s' and DocDate le '%s' ", startDateStr, endDateStr);
         String query = "$crossjoin(Invoices,Invoices/DocumentLines,Items,BusinessPartners)?$expand=Invoices($select=DocEntry,DocNum,DocType,DocDate,DocDueDate,CardCode,CardName,DocTotal,Address,Address2,VatPercent),Invoices/DocumentLines($select=ItemCode,ItemDescription,Quantity,Rate,LineTotal,UoMCode,DiscountPercent,U_HS,GrossTotal,LineTotal,TaxTotal,LineNum),Items($select=ItemCode,ItemName,QuantityOrderedByCustomers,U_HSCode,U_Weight,U_CartonUnits),BusinessPartners($select=Address,Block,FederalTaxID,AdditionalID,U_RegType,CardCode)&$filter=" + filter;
         String fullInvoiceUrl = baseUrl + query;
         String payload = String.format("{\n    \"loginUrl\": \"%s\",\n    \"invoiceUrl\": \"%s\",\n    \"loginPayload\": {\n        \"UserName\": \"%s\",\n        \"Password\": \"%s\",\n        \"CompanyDB\": \"%s\"\n    }\n}\n", this.cred.getsap_login_url(), fullInvoiceUrl, this.cred.getsap_username(), this.cred.getsap_password(), this.cred.getsap_company_db());
         System.out.println(fullInvoiceUrl);

               CloseableHttpClient httpClient = HttpClients.createDefault();
                  HttpPost post = new HttpPost(url);
                  post.setHeader("Content-Type", "application/json");
                  post.setEntity(new StringEntity(payload, StandardCharsets.UTF_8));
                     CloseableHttpResponse response;
                     response = httpClient.execute(post);
                     String responseBody ="";
                     try {
                        int statusCode = response.getStatusLine().getStatusCode();
                        responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                        System.out.println("Laravel Response (Status " + statusCode + "):");
                        System.out.println(responseBody);
                        
                     } finally {
                        if (response != null) {
                           response.close();
                        }

                     }
               

                  if (httpClient != null) {
                     httpClient.close();
                  }

                  return responseBody;



      } catch (Exception ex) {
         ex.printStackTrace();
         return "Error during SAP API communication: " + ex.getMessage();
      }
   }

   Set<String> getExistingInvoices() {
      Set<String> existingDocEntries = new HashSet();
      String sql = "SELECT doc_entry_no FROM adempiere.sap_invoice WHERE ad_org_id = " + this.org_id + " AND invoice_date BETWEEN ? AND ?";
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         pstmt = DB.prepareStatement(sql, this.get_TrxName());
         pstmt.setTimestamp(1, this.p_startdate);
         pstmt.setTimestamp(2, this.p_enddate);
         rs = pstmt.executeQuery();

         while(rs.next()) {
            existingDocEntries.add(rs.getString("doc_entry_no"));
         }
      } catch (Exception var8) {
      } finally {
         DB.close(rs, pstmt);
      }

      return existingDocEntries;
   }

   public Map<String, String> GetTaxTotal(JsonNode lineNode, int docEntry, String baseUrl) {
      Map<String, String> taxResult = new HashMap();
      taxResult.put("gst_tax", "0");
      taxResult.put("additional_tax", "0");
      taxResult.put("further_tax", "0");
      BigDecimal total_further_tax = Env.ZERO;

         try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

               String fullInvoiceUrl = baseUrl + "Invoices(" + docEntry + ")";
               String payload = String.format("{\n    \"loginUrl\": \"%s\",\n    \"invoiceUrl\": \"%s\",\n    \"loginPayload\": {\n        \"UserName\": \"%s\",\n        \"Password\": \"%s\",\n        \"CompanyDB\": \"%s\"\n    }\n}\n", this.cred.getsap_login_url(), fullInvoiceUrl, this.cred.getsap_username(), this.cred.getsap_password(), this.cred.getsap_company_db());
               HttpPost post = new HttpPost("https://uactros.myinfinitycrms.com/api/sap-bridge-get_inv");
               post.setHeader("Content-Type", "application/json");
               post.setEntity(new StringEntity(payload, StandardCharsets.UTF_8));
               Throwable var11 = null;
               Object var12 = null;

                  CloseableHttpResponse response = httpClient.execute(post);

                     String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                     System.out.println("Laravel Bridge Response:");
                     System.out.println(responseBody);
                     ObjectMapper mapper = new ObjectMapper();
                     JsonNode root = mapper.readTree(responseBody);
                     String currentLineNum = lineNode.path("LineNum").asText("0");
                     JsonNode documentLines = root.path("invoices").path("DocumentLines");
                     if (documentLines.isArray()) {
                        Iterator var20 = documentLines.iterator();

                        while(var20.hasNext()) {
                           JsonNode docLine = (JsonNode)var20.next();
                           String docLineNum = docLine.path("LineNum").asText("0");
                           if (currentLineNum.equals(docLineNum)) {
                              JsonNode additionalExpenses = docLine.path("DocumentLineAdditionalExpenses");
                              if (additionalExpenses.isArray()) {
                                 Iterator var24 = additionalExpenses.iterator();

                                 while(true) {
                                    while(var24.hasNext()) {
                                       JsonNode expense = (JsonNode)var24.next();
                                       int expenseCode = expense.path("ExpenseCode").asInt(0);
                                       String lineTotal = expense.path("LineTotal").asText("0");
                                       if (expenseCode == 5) {
                                          taxResult.put("gst_tax", lineTotal);
                                       } else if (expenseCode == 10) {
                                          taxResult.put("further_tax", lineTotal);
                                       } else if (expenseCode == 6 || expenseCode == 7 || expenseCode == 4 || expenseCode == 8) {
                                    	   total_further_tax = total_further_tax.add(new BigDecimal(lineTotal)); 
                                          taxResult.put("additional_tax", total_further_tax.toString());
                                       }
                                    }

                                    return taxResult;
                                 }
                              }
                              break;
                           }
                        }
                     }
                     if (response != null) {
                        response.close();
                     }

                
                
               if (httpClient != null) {
                  httpClient.close();

            }
      } catch (Exception ex) {
    	  ex.printStackTrace();
         taxResult.put("error", "Error calling Laravel Bridge: " + ex.getMessage());
      }

      return taxResult;
   }
}