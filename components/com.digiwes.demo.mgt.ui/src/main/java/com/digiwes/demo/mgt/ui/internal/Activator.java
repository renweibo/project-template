package com.digiwes.demo.mgt.ui.internal;

//import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liurl3 on 2015/12/10.
 */
public class Activator implements BundleActivator {
    private static BundleContext bundleContext;
    private static Logger log = LoggerFactory.getLogger(Activator.class);

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        log.info("demo ui bundle start");
        this.bundleContext = bundleContext;
    }

    public static BundleContext getBundleContext(){
        log.info("demo ui bundle get BundleContext");
        return bundleContext;
    }
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        log.info("The cancellation of the service");

    }
}
