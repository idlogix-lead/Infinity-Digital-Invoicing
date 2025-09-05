package com.idlogix.factories;

import org.adempiere.base.IProcessFactory;
import org.compiere.process.ProcessCall;

import com.idlogix.process.FBR_Api_Call;
import com.idlogix.process.HSCodeApi;
import com.idlogix.process.PostInvoiceOnFBR;
import com.idlogix.process.UpdateOnSAP;



public class ProcessFactory implements IProcessFactory {

	@Override
	public ProcessCall newProcessInstance(String className) {
		// TODO Auto-generated method stub
		if (className.equals("com.idlogix.process.FBR_Api_Call"))
			return  new FBR_Api_Call();
		if (className.equals("com.idlogix.process.HSCodeApi"))
			return  new HSCodeApi();
		if (className.equals("com.idlogix.process.PostInvoiceOnFBR"))
			return  new PostInvoiceOnFBR();
		if (className.equals("com.idlogix.process.UpdateOnSAP"))
			return  new UpdateOnSAP();
		return null;
	}

}
