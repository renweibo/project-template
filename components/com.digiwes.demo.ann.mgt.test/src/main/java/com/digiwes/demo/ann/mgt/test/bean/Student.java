package com.digiwes.demo.ann.mgt.test.bean;

import com.digiwes.demo.ann.mgt.edmann.EDMEntityType;
import com.digiwes.demo.ann.mgt.edmann.EDMKeyProperty;
import com.digiwes.demo.ann.mgt.edmann.EDMProperty;

/**
 * Created by liurl3 on 2016/4/6.
 */
@EDMEntityType
public class Student {
    @EDMKeyProperty("Student")
    private String id;
    @EDMProperty("Student")
    private String studnetName;

    @EDMProperty("Student")
    private int studentAge;

    @EDMProperty("Student")
    private String studentOption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getStudnetName() {
        return studnetName;
    }

    public void setStudnetName(String studnetName) {
        this.studnetName = studnetName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentOption() {
        return studentOption;
    }

    public void setStudentOption(String studentOption) {
        this.studentOption = studentOption;
    }
}
