package com.digiwes.demo.mgt.internal;

/**
 * Created by liurl3 on 2015/12/9.
 */
import com.digiwes.demo.mgt.service.IPersonService;
import com.digiwes.demo.mgt.service.impl.PersonService;
//import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {
    private ServiceRegistration sp ;
    private static Logger log = LoggerFactory.getLogger(Activator.class);
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        log.info("demo mgt bundle start Regiset Service");
        sp = bundleContext.registerService(
                IPersonService.class.getName(), new PersonService(), null);
    }
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        log.info("The cancellation of the service");
       sp.unregister();
    }
}
