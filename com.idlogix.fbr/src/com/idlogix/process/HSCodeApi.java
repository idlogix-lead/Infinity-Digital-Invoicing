package com.idlogix.process;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idlogix.model.MFBRUom;
import com.idlogix.model.MHSCode;
import com.idlogix.model.MSAPFBRCredential;


@org.adempiere.base.annotation.Process
public class HSCodeApi extends SvrProcess {
	
	MSAPFBRCredential cred = new Query(getCtx(), MSAPFBRCredential.Table_Name, "isActive = 'Y'", get_TrxName())
		    .setOrderBy("created DESC")
		    .first();
	
	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String doIt() throws Exception {
		fetchAndSaveHSCodes();
		fetchAndSaveHSUOM();
		 
		 return null;
    }
	void fetchAndSaveHSCodes() {
	    String url = "https://gw.fbr.gov.pk/pdi/v1/itemdesccode";
	    String bearerToken = cred.getfbr_bearer_token();
	    
	    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	        HttpGet get = new HttpGet(url);
	        get.setHeader("Accept", "application/json");
	        get.setHeader("Authorization", "Bearer " + bearerToken);

	        try (CloseableHttpResponse response = httpClient.execute(get)) {
	            int statusCode = response.getStatusLine().getStatusCode();
	            String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

	            if (statusCode >= 200 && statusCode < 300) {
	                ObjectMapper mapper = new ObjectMapper();
	                JsonNode root = mapper.readTree(responseBody);

	                if (root.isArray()) {
	                    for (JsonNode node : root) {
	                        String hsCode = node.path("hS_CODE").asText();
	                        String description = node.path("description").asText();

	                        if (hsCode != null && !hsCode.isEmpty()) {
	                        	MHSCode code = new MHSCode(getCtx(), 0, get_TrxName());
//	                            MHSCode code = new MHSCode(Env.getCtx(), 0, null); // create new record
	                            code.setName(hsCode);
	                            code.setDescription(description);
	                            code.setIsActive(true); // optional, depending on your table
	                            code.saveEx();
	                        }
	                    }
	                    System.out.println("HS codes imported successfully.");
	                } else {
	                    System.err.println("Unexpected JSON structure.");
	                }
	            } else {
	                System.err.println("Failed to fetch HS Codes. HTTP Status: " + statusCode);
	                System.err.println(responseBody);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	void fetchAndSaveHSUOM() {
	    List<MHSCode> allCodes = new Query(getCtx(), MHSCode.Table_Name, "IsActive='Y'", get_TrxName())
	            .setOnlyActiveRecords(true)
	            .list();

	    String baseUrl = "https://gw.fbr.gov.pk/pdi/v2/HS_UOM?annexure_id=3";
	    String bearerToken = cred.getfbr_bearer_token();

	    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
	        for (MHSCode hsCode : allCodes) {
	            String fullUrl = baseUrl + "&hs_code=" + URLEncoder.encode(hsCode.getName(), StandardCharsets.UTF_8);
	            HttpGet get = new HttpGet(fullUrl);
	            get.setHeader("Accept", "application/json");
	            get.setHeader("Authorization", "Bearer " + bearerToken);

	            try (CloseableHttpResponse response = httpClient.execute(get)) {
	                int statusCode = response.getStatusLine().getStatusCode();
	                String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

	                if (statusCode >= 200 && statusCode < 300) {
	                    ObjectMapper mapper = new ObjectMapper();
	                    JsonNode root = mapper.readTree(responseBody);

	                    if (root != null && root.isArray() && root.size() > 0) {
	                        JsonNode first = root.get(0);
	                        String uomDesc = first.path("description").asText();
	                        String uomID = first.path("uoM_ID").asText();

	                        if (uomDesc != null && !uomDesc.isEmpty()) {
	                            MFBRUom uom = new MFBRUom(getCtx(), 0, get_TrxName());
	                            uom.setName(uomDesc);
	                            uom.setHS_Codes_ID(hsCode.get_ID());
	                            uom.setDescription(hsCode.getName());
	                            uom.saveEx();
	                        }
	                    }
	                } else {
	                    System.err.println("Failed to fetch UOM for HS Code: " + hsCode.getName());
	                    System.err.println(responseBody);
	                }

	            } catch (Exception e) {
	                System.err.println("Error for HS Code: " + hsCode.getName());
	                e.printStackTrace();
	            }
	        }

	        System.out.println("UOMs imported successfully.");

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}





}
