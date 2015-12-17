package com.digiwes.demo.mgt.ui.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by liurl3 on 2015/12/10.
 */
public class Activator implements BundleActivator {
    private static BundleContext bundleContext;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        this.bundleContext = bundleContext;
    }

    public static BundleContext getBundleContext(){
        return bundleContext;
    }
    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
