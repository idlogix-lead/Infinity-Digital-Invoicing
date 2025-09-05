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

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bsh.This;

public class MSAPFBRCredential extends X_sap_fbr_credential{

	public MSAPFBRCredential(Properties ctx, int SAP_Invoice_ID, String trxName, String... virtualColumns) {
		super(ctx, SAP_Invoice_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSAPFBRCredential(Properties ctx, int SAP_Invoice_ID, String trxName) {
		super(ctx, SAP_Invoice_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSAPFBRCredential(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSAPFBRCredential(Properties ctx, String SAP_Invoice_UU, String trxName, String... virtualColumns) {
		super(ctx, SAP_Invoice_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSAPFBRCredential(Properties ctx, String SAP_Invoice_UU, String trxName) {
		super(ctx, SAP_Invoice_UU, trxName);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean beforeSave(boolean newRecord) {
		// TODO Auto-generated method stub
		
		String filterString = COLUMNNAME_AD_Org_ID + " = " + getAD_Org_ID() + " and " + COLUMNNAME_sap_fbr_credential_ID + " <> " + get_ID() ;
		List<MSAPFBRCredential> credentials = new Query(p_ctx, Table_Name, filterString, get_TrxName()).list();
		if(credentials.size() > 0)
			throw new AdempiereException("Credntials for this Organization Already Exists!");
		return super.beforeSave(newRecord);
	}

}
