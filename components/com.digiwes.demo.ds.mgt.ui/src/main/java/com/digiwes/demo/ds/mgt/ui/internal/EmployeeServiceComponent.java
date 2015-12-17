package com.digiwes.demo.ds.mgt.ui.internal;

import com.digiwes.demo.ds.mgt.service.IEmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;


public class EmployeeServiceComponent {
    private static Log log = LogFactory.getLog(EmployeeServiceComponent.class);
    private static IEmployeeService employeeService;

    protected void activate(ComponentContext ctxt) {

    }

    /**
     * 注册服务
     * @param employeeService
     */
    public void setEmployeeService(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    /**
     * 注销服务
     * @param employeeService
     */
    public void unsetEmployeeService(IEmployeeService employeeService){
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
