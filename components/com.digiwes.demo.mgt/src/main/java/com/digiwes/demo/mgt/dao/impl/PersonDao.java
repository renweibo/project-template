package com.digiwes.demo.mgt.dao.impl;

import com.digiwes.demo.mgt.bean.Person;
import com.digiwes.demo.mgt.dao.IPersonDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class PersonDao implements IPersonDao{
    private static Map<String,Person> personMap ;
    static {
        personMap = new HashMap<String,Person>();
        Person person = new Person();
        person.setId("001");
        person.setName("Tom");
        person.setAge(25);

        Person person2 = new Person();
        person2.setId("002");
        person2.setName("Join");
        person2.setAge(27);

        personMap.put("001", person);
        personMap.put("002",person2);
    }
    @Override
    public List<Person> getPersonList() {
        List<Person> personList = new ArrayList<Person>();
        for(Person person : personMap.values()){
            personList.add(person);
        }
        return personList;
    }
}
