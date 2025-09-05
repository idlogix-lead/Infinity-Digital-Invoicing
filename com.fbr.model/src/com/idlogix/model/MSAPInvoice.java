package com.idlogix.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sound.sampled.Line;
import javax.swing.plaf.BorderUIResource.LineBorderUIResource;

import org.compiere.model.Query;
import org.compiere.util.AdempiereUserError;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bsh.This;

public class MSAPInvoice extends X_SAP_Invoice{

	public MSAPInvoice(Properties ctx, int SAP_Invoice_ID, String trxName, String... virtualColumns) {
		super(ctx, SAP_Invoice_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoice(Properties ctx, int SAP_Invoice_ID, String trxName) {
		super(ctx, SAP_Invoice_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoice(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoice(Properties ctx, String SAP_Invoice_UU, String trxName, String... virtualColumns) {
		super(ctx, SAP_Invoice_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoice(Properties ctx, String SAP_Invoice_UU, String trxName) {
		super(ctx, SAP_Invoice_UU, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public List<MSAPInvoiceLine> getLines(){
		String filter = MSAPInvoiceLine.COLUMNNAME_SAP_Invoice_ID + " = ?";
		List<MSAPInvoiceLine> lines =new Query(p_ctx, MSAPInvoiceLine.Table_Name, filter, get_TrxName()).setParameters(get_ID()).list(); 
		return lines;
	}
	
	public String getFBRJsonPayload(MSAPFBRCredential cred) {
		
		String jsonPayloadString = null;
		List<MSAPInvoiceLine> lines = getLines();
	    Map<String, Object> payload = new LinkedHashMap<>();
	    List<Map<String, Object>> items = new ArrayList<>();
	    
        payload.put("invoiceType", "Sale Invoice".trim());
        Timestamp invoiceDate = getinvoice_date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        payload.put("invoiceDate", sdf.format(invoiceDate).toString());
        payload.put("sellerBusinessName", cred.getseller_business_name());
        payload.put("sellerProvince", cred.getseller_province());
        payload.put("sellerAddress", cred.getseller_address());
        payload.put("sellerNTNCNIC", cred.getseller_ntn_cnic());
        payload.put("buyerNTNCNIC", getbuyer_ntn_cnic());
        payload.put("buyerBusinessName", getbuyer_business_name());
        payload.put("buyerProvince", getbuyer_province());
        payload.put("buyerAddress", getbuyer_address());
        payload.put("invoiceRefNo", getinvoice_ref_no());
        payload.put("provinceCode", getprovince_code());
        payload.put("cityCode", getcity_code());
        payload.put("address", getAddress());
        payload.put("buyerRegistrationType", getbuyer_registration_type());
        payload.put("scenarioId", getscenario_id());
        payload.put("items", items);
        for(MSAPInvoiceLine line : lines) {
        	Map<String, Object> item = new LinkedHashMap<>();
//        	String hsCode = line.geths_code();
//            
//            // Lookup in MHSCode model
//            MHSCode code = MHSCode.getByHSCode(getCtx(), hsCode, get_TrxName());     
//            if (code == null) {
//                throw new AdempiereUserError("HS Code " + hsCode + " does not exist in FBR HSCodes.");
//            }
//
//            item.put("hsCode", hsCode);
		    item.put("hsCode",line.geths_code());
	        item.put("productDescription", line.getproduct_description());
	        item.put("rate", line.getRate());
	        
	        String uom = line.getuom();
	        item.put("uoM", uom);
//	        MFBRUom code = MFBRUom.getByUom(getCtx(), uom, get_TrxName());     
//	         if (code == null) {
//	              throw new AdempiereUserError("UOM " + uom + " does not exist in against."+line.geths_code()+"HSCODE");
//	         }
	        item.put("quantity",line.getquantity());
	        item.put("totalValues", line.gettotal_values()); //118
//	        item.put("valueSalesExcludingST", "100");
	        item.put("valueSalesExcludingST", line.getvalue_sales_excluding_st());
//	        item.put("salesTaxApplicable", "18");
	        item.put("salesTaxApplicable", line.getsales_tax_applicable());
//	        BigDecimal taxApplicable = line.getsales_tax_applicable(); // e.g. 18
//	        BigDecimal valueExclST = line.getvalue_sales_excluding_st(); // e.g. 100
//
//	        String rate;
//	        if (valueExclST != null && valueExclST.compareTo(BigDecimal.ZERO) > 0) {
//	            BigDecimal ratePercent = taxApplicable
//	                .divide(valueExclST, 4, RoundingMode.HALF_UP) // safe divide
//	                .multiply(BigDecimal.valueOf(100)); // to percentage
//
//	            // Round to 2 decimal places and append %
//	            rate = ratePercent.setScale(2, RoundingMode.HALF_UP).toPlainString() + "%";
//	        } else {
//	            rate = "0%"; // fallback if valueExclST is zero or null
//	        }
//
//	        item.put("rate", rate);
//	        item.put("rate", "18%");
	        item.put("fixedNotifiedValueOrRetailPrice", line.getfixed_notified_value_or_retail_price());
	        item.put("salesTaxWithheldAtSource", line.getsales_tax_withheld_at_source());
	        item.put("extraTax", line.getextra_tax());
	        item.put("furtherTax", line.getfurther_tax());
	        item.put("sroScheduleNo", line.getsro_schedule_no());
	        item.put("fedPayable", line.getfed_payable());
	        BigDecimal discount = line.getDiscount();
	        discount = discount.setScale(2, RoundingMode.HALF_UP);
	        item.put("discount", discount.toString());
//	        item.put("discount", line.getDiscount());
	        item.put("saleType",line.getsale_type());
	        item.put("sroItemSerialNo", line.getsro_item_serial_no());
	        item.put("supplyDestination", line.getsupply_destination());
	        items.add(item);
        	
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
			jsonPayloadString = mapper.writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonPayloadString;
	}
	
	

}
