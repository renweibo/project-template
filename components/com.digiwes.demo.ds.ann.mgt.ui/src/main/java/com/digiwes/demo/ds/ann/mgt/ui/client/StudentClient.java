package com.digiwes.demo.ds.ann.mgt.ui.client;

import com.digiwes.demo.ds.ann.mgt.bean.Student;
import com.digiwes.demo.ds.ann.mgt.service.IStudentService;
import com.digiwes.demo.ds.ann.mgt.ui.internal.StudentServiceComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class StudentClient {
    private static Logger log = LoggerFactory.getLogger(StudentClient.class);
    private static StudentClient employeeClient = new StudentClient();
    private StudentClient(){

    }
    public static StudentClient getInstance(){
        log.info("Instance StudentClient");
        return employeeClient;
    }

    public List<Student> getStudentList(){
        List<Student> studentList = null;
        //Get Service
        IStudentService studentService = StudentServiceComponent.getService();
        if(studentService != null){
            studentList = studentService.getStudentList();
        }else {
            log.error("personService is null");
        }

        return studentList;
    }
}
