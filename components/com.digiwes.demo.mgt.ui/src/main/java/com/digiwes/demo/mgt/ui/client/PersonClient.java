package com.digiwes.demo.mgt.ui.client;
import com.digiwes.demo.mgt.bean.Person;
import com.digiwes.demo.mgt.service.IPersonService;
import com.digiwes.demo.mgt.ui.internal.Activator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class PersonClient{
    private static Logger log = LoggerFactory.getLogger(PersonClient.class);
    private static BundleContext context ;
    private static PersonClient personClient = new PersonClient();
    private PersonClient(){

    }
    public static PersonClient getInstance(){
        context = Activator.getBundleContext();
        return personClient;
    }
    public List<Person> getPersons(){
        List<Person> personList = null ;
        //获取服务
        IPersonService personService = null;
        if(context != null) {
            ServiceReference sp = context.getServiceReference(IPersonService.class.getName());
            if (sp != null) {
                personService = (IPersonService) context.getService(sp);
            }else{
                log.error("ServiceReference is null");
            }
            if (personService != null) {
                personList = personService.getPersonList();
            }else{
                log.error("personService is null");
            }
        }else{
            log.error("BundleContext is null");
        }
        return personList;
    }

}
