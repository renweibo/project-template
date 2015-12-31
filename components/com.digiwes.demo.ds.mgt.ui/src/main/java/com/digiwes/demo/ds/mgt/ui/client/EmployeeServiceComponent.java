package com.digiwes.demo.ds.mgt.ui.client;

import com.digiwes.demo.ds.mgt.service.IEmployeeService;
//import org.apache.log4j.Logger;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmployeeServiceComponent {
    private static Logger log = LoggerFactory.getLogger(EmployeeServiceComponent.class);
    private static IEmployeeService employeeService;

    protected void activate(ComponentContext ctxt) {

    }

    /**
     * Regist Service
     * @param employeeService
     */
    public void setEmployeeService(IEmployeeService employeeService){
        log.info("Regist of the IEmployeeService");
        this.employeeService = employeeService;
    }

    /**
     * Cancel Service
     * @param employeeService
     */
    public void unsetEmployeeService(IEmployeeService employeeService){
        log.info("The cancellation of the IEmployeeService");
        if(employeeService != this.employeeService){
            return ;
        }
        this.employeeService = null;
    }
    public static IEmployeeService getService(){
        return employeeService;
    }
    /**
     *
     * @param ctxt
     */
    protected void deactivate(ComponentContext ctxt) {
        log.debug("DEMO Person Management bundle is deactivated");
    }
}
