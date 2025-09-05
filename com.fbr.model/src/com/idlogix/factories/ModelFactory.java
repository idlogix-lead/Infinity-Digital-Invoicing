package com.idlogix.factories;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

import com.idlogix.model.MFBRUom;
import com.idlogix.model.MHSCode;
import com.idlogix.model.MSAPFBRCredential;
import com.idlogix.model.MSAPInvoice;
import com.idlogix.model.MSAPInvoiceLine;



public class ModelFactory implements IModelFactory{

	@Override
	public Class<?> getClass(String tableName) {
		// TODO Auto-generated method stub
		if (tableName.equals(MFBRUom.Table_Name)) { return MFBRUom.class; }
		if (tableName.equals(MHSCode.Table_Name)) { return MHSCode.class; }
		if (tableName.equals(MSAPFBRCredential.Table_Name)) { return MSAPFBRCredential.class; }
		if (tableName.equals(MSAPInvoice.Table_Name)) { return MSAPInvoice.class; }
		if (tableName.equals(MSAPInvoiceLine.Table_Name)) { return MSAPInvoiceLine.class; }
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		// TODO Auto-generated method stub
		if (tableName.equals(MFBRUom.Table_Name)) { return new MFBRUom(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MHSCode.Table_Name)) { return new MHSCode(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MSAPFBRCredential.Table_Name)) { return new MSAPFBRCredential(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MSAPInvoice.Table_Name)) { return new MSAPInvoice(Env.getCtx(), Record_ID, trxName); }
		if (tableName.equals(MSAPInvoiceLine.Table_Name)) { return new MSAPInvoiceLine(Env.getCtx(), Record_ID, trxName); }
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		// TODO Auto-generated method stub
		if (tableName.equals(MFBRUom.Table_Name)) { return new MFBRUom(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MHSCode.Table_Name)) { return new MHSCode(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MSAPFBRCredential.Table_Name)) { return new MSAPFBRCredential(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MSAPInvoice.Table_Name)) { return new MSAPInvoice(Env.getCtx(), rs, trxName); }
		if (tableName.equals(MSAPInvoiceLine.Table_Name)) { return new MSAPInvoiceLine(Env.getCtx(), rs, trxName); }
		return null;
	}

}
