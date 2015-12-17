package com.digiwes.demo.ds.mgt.ui.client;

import com.digiwes.demo.ds.mgt.bean.Employee;
import com.digiwes.demo.ds.mgt.service.IEmployeeService;
import com.digiwes.demo.ds.mgt.ui.internal.EmployeeServiceComponent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class EmployeeClient {
    private static Log log = LogFactory.getLog(EmployeeClient.class);
    private static EmployeeClient employeeClient = new EmployeeClient();
    private EmployeeClient(){

    }
    public static EmployeeClient getInstance(){
        return employeeClient;
    }

    public List<Employee> getEmployeeList(){
        List<Employee> employeeList = null;
        //获取服务
        IEmployeeService employeeService = EmployeeServiceComponent.getService();
        if(employeeService != null){
            employeeList = employeeService.getEmployeeList();
        }else {
            log.error("personService is null");
        }

        return employeeList;
    }
}
