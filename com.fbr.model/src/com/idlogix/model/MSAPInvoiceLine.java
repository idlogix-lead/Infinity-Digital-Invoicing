package com.idlogix.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MSAPInvoiceLine extends X_SAP_Invoiceline{

	public MSAPInvoiceLine(Properties ctx, int SAP_Invoiceline_ID, String trxName, String... virtualColumns) {
		super(ctx, SAP_Invoiceline_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoiceLine(Properties ctx, int SAP_Invoiceline_ID, String trxName) {
		super(ctx, SAP_Invoiceline_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoiceLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoiceLine(Properties ctx, String SAP_Invoiceline_UU, String trxName, String... virtualColumns) {
		super(ctx, SAP_Invoiceline_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MSAPInvoiceLine(Properties ctx, String SAP_Invoiceline_UU, String trxName) {
		super(ctx, SAP_Invoiceline_UU, trxName);
		// TODO Auto-generated constructor stub
	}
//	@Override
//	protected boolean afterDelete(boolean success) {
//		// TODO Auto-generated method stub
//		if(success)
//			((MSAPInvoice)this.getSAP_Invoice()).recalculateGrandTotal(get_TrxName());
//		return super.afterDelete(success);
//	}
//	@Override
//	protected boolean afterSave(boolean newRecord, boolean success) {
//		// TODO Auto-generated method stub
//		if(success)
//			((MSAPInvoice)this.getSAP_Invoice()).recalculateGrandTotal(get_TrxName());
//		return super.afterSave(newRecord, success);
//	}
}
