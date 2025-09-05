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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bsh.This;

public class MHSCode extends X_HS_Codes{

	public MHSCode(Properties ctx, int HS_Code_ID, String trxName, String... virtualColumns) {
		super(ctx, HS_Code_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MHSCode(Properties ctx, int HS_Code_ID, String trxName) {
		super(ctx, HS_Code_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MHSCode(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MHSCode(Properties ctx, String HS_Code_UU, String trxName, String... virtualColumns) {
		super(ctx, HS_Code_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MHSCode(Properties ctx, String HS_Code_UU, String trxName) {
		super(ctx, HS_Code_UU, trxName);
		// TODO Auto-generated constructor stub
	}
	public static MHSCode getByHSCode(Properties ctx, String hsCode, String trxName) {
	    String whereClause = "name = ?";
	    return new Query(ctx, Table_Name, whereClause, trxName)
	        .setParameters(hsCode)
	        .first();
	}
	
	

}
