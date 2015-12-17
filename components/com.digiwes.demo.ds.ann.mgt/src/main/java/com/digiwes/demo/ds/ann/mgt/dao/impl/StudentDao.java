package com.digiwes.demo.ds.ann.mgt.dao.impl;

import com.digiwes.demo.ds.ann.mgt.bean.Student;
import com.digiwes.demo.ds.ann.mgt.dao.IStudentDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class StudentDao implements IStudentDao {
    private static Map<String,Student> studentMap ;
    static {
        studentMap = new HashMap<String,Student>();
        Student student = new Student();
        student.setId("101");
        student.setName("ann_Brett");
        student.setAge(25);

        Student student2 = new Student();
        student2.setId("102");
        student2.setName("ann_Jason");
        student2.setAge(27);

        studentMap.put("101", student);
        studentMap.put("102",student2);
    }
    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<Student>();
        for(Student student : studentMap.values()){
            studentList.add(student);
        }
        return studentList;
    }
}
