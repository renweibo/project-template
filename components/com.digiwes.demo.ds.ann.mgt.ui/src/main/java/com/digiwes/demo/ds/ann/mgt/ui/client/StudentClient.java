package com.digiwes.demo.ds.ann.mgt.ui.client;

import com.digiwes.demo.ds.ann.mgt.bean.Student;
import com.digiwes.demo.ds.ann.mgt.service.IStudentService;
import com.digiwes.demo.ds.ann.mgt.ui.internal.StudentServiceComponent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class StudentClient {
    private static Log log = LogFactory.getLog(StudentClient.class);
    private static StudentClient employeeClient = new StudentClient();
    private StudentClient(){

    }
    public static StudentClient getInstance(){
        return employeeClient;
    }

    public List<Student> getStudentList(){
        List<Student> studentList = null;
        //��ȡ����
        IStudentService studentService = StudentServiceComponent.getService();
        if(studentService != null){
            studentList = studentService.getStudentList();
        }else {
            log.error("personService is null");
        }

        return studentList;
    }
}
