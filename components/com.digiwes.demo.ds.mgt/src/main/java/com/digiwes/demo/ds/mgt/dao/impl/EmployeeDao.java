package com.digiwes.demo.ds.mgt.dao.impl;

import com.digiwes.demo.ds.mgt.bean.Employee;
import com.digiwes.demo.ds.mgt.dao.IEmployeeDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class EmployeeDao implements IEmployeeDao {
    private static Map<String,Employee> employeeMap ;
    static {
        employeeMap = new HashMap<String,Employee>();
        Employee employee = new Employee();
        employee.setId("101");
        employee.setName("Brett");
        employee.setAge(25);

        Employee employee2 = new Employee();
        employee2.setId("102");
        employee2.setName("Jason");
        employee2.setAge(27);

        employeeMap.put("101", employee);
        employeeMap.put("102",employee2);
    }
    @Override
    public List<Employee> getEmoloyeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();
        for(Employee employee : employeeMap.values()){
            employeeList.add(employee);
        }
        return employeeList;
    }
}
