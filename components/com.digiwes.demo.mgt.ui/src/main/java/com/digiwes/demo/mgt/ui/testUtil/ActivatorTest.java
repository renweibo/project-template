package com.digiwes.demo.mgt.ui.testUtil;

import com.digiwes.demo.mgt.bean.Person;
import com.digiwes.demo.mgt.ui.client.PersonClient;

import java.util.List;

/**
 * Created by liurl3 on 2015/12/11.
 */
public class ActivatorTest {
    public static void main(String[] arg){
        PersonClient client = null ;
        List<Person> persons = null ;
        String msg ;
        try {
            client = PersonClient.getInstance();
            if(client != null){
                persons = client.getPersons();
                System.out.println("persons"+persons);
            }else{
                System.out.println("client is null");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
