package com.digiwes.demo.ann.mgt.test.bean;

import com.digiwes.demo.ann.mgt.edmann.EDMEntityType;
import com.digiwes.demo.ann.mgt.edmann.EDMKeyProperty;
import com.digiwes.demo.ann.mgt.edmann.EDMProperty;

/**
 * Created by liurl3 on 2015/12/9.
 */
@EDMEntityType
public class Person {
    @EDMKeyProperty(Person.class)
    private String id;
    @EDMProperty(Person.class)
    private String name;

    @EDMProperty(Person.class)
    private int age;

    @EDMProperty(Person.class)
    private String option;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
