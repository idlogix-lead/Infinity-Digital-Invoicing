package com.idlogix.fbr;

import org.adempiere.base.Core;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Core.getMappedProcessFactory().scan(bundleContext, "com.idlogix.process");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
