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

public class MFBRUom extends X_FBR_Uom{

	public MFBRUom(Properties ctx, int FBR_Uom_ID, String trxName, String... virtualColumns) {
		super(ctx, FBR_Uom_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFBRUom(Properties ctx, int FBR_Uom_ID, String trxName) {
		super(ctx, FBR_Uom_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFBRUom(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFBRUom(Properties ctx, String FBR_Uom_UU, String trxName, String... virtualColumns) {
		super(ctx, FBR_Uom_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFBRUom(Properties ctx, String FBR_Uom_UU, String trxName) {
		super(ctx, FBR_Uom_UU, trxName);
		// TODO Auto-generated constructor stub
	}
	public static MFBRUom getByUom(Properties ctx, String uom, String trxName) {
	    String whereClause = "name = ?";
	    return new Query(ctx, Table_Name, whereClause, trxName)
	        .setParameters(uom)
	        .first();
	}
	
	

}
