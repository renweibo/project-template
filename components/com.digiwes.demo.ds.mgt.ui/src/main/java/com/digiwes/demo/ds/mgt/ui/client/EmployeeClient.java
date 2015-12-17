package com.digiwes.demo.ds.mgt.ui.client;

import com.digiwes.demo.ds.mgt.bean.Employee;
import com.digiwes.demo.ds.mgt.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class EmployeeClient {
    private static Logger log = LoggerFactory.getLogger(EmployeeClient.class);
    private static EmployeeClient employeeClient = new EmployeeClient();
    private static IEmployeeService employeeService;
    private EmployeeClient(){

    }
    public static EmployeeClient getInstance(){
        return employeeClient;
    }

    public List<Employee> getEmployeeList(){
        List<Employee> employeeList = null;
        //获取服务
       IEmployeeService employeeService = EmployeeServiceComponent.getService();
        System.out.println("getEmployeeList employeeService " + employeeService);
        if(employeeService != null){
            employeeList = employeeService.getEmployeeList();
        }else {
            log.error("personService is null");
        }

        return employeeList;
    }
}
