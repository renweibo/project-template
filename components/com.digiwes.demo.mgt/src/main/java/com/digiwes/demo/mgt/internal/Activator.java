package com.digiwes.demo.mgt.internal;

/**
 * Created by liurl3 on 2015/12/9.
 */
import com.digiwes.demo.mgt.service.IPersonService;
import com.digiwes.demo.mgt.service.impl.PersonService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration sp ;
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        //×¢²áservice
        sp = bundleContext.registerService(
                IPersonService.class.getName(), new PersonService(), null);
    }
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        //×¢Ïúservice
       sp.unregister();
    }
}
