package com.digiwes.demo.ds.mgt.service.impl;

import com.digiwes.demo.ds.mgt.bean.Employee;
import com.digiwes.demo.ds.mgt.dao.IEmployeeDao;
import com.digiwes.demo.ds.mgt.dao.impl.EmployeeDao;
import com.digiwes.demo.ds.mgt.service.IEmployeeService;

import java.util.List;

/**
 * Created by liurl3 on 2015/12/11.
 */
public class EmployeeService implements IEmployeeService {
    private IEmployeeDao employeeDao = new EmployeeDao();
    @Override
    public List<Employee> getEmployeeList() {
        return employeeDao.getEmoloyeeList();
    }
}
