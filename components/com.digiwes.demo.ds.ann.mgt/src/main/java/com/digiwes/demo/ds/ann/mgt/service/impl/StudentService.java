package com.digiwes.demo.ds.ann.mgt.service.impl;

import com.digiwes.demo.ds.ann.mgt.bean.Student;
import com.digiwes.demo.ds.ann.mgt.dao.IStudentDao;
import com.digiwes.demo.ds.ann.mgt.dao.impl.StudentDao;
import com.digiwes.demo.ds.ann.mgt.service.IStudentService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import java.util.List;

/**
 * Created by liurl3 on 2015/12/11.
 */
@Component (name = "demo.student.service",immediate = true)
@Service (value = IStudentService.class)
public class StudentService implements IStudentService {
    private IStudentDao studentDao = new StudentDao();
    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }
}
