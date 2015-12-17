package com.digiwes.demo.mgt.service.impl;

import com.digiwes.demo.mgt.bean.Person;
import com.digiwes.demo.mgt.dao.IPersonDao;
import com.digiwes.demo.mgt.dao.impl.PersonDao;
import com.digiwes.demo.mgt.service.IPersonService;

import java.util.List;

/**
 * Created by liurl3 on 2015/12/9.
 */
public class PersonService implements IPersonService {
    private IPersonDao personDao = new PersonDao();
    @Override
    public List<Person> getPersonList() {
        return personDao.getPersonList();
    }
}
