package com.digiwes.demo.ds.ann.mgt.ui.internal;


import com.digiwes.demo.ds.ann.mgt.service.IStudentService;
//import org.apache.log4j.Logger;
import org.apache.felix.scr.annotations.*;
import org.osgi.service.component.ComponentContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(name = "demo.student.component",immediate = true)
@Reference(name = "demo.student.service",referenceInterface = IStudentService.class,
        policy = ReferencePolicy.DYNAMIC,bind = "setStudentService",
        unbind = "unsetStudentService")
public class StudentServiceComponent {
    private static Logger log = LoggerFactory.getLogger(StudentServiceComponent.class);
    private static IStudentService studentService;

    @Activate
    protected void activate(ComponentContext ctxt) {
        log.info("DEMO Student UI bundle is registed");
    }

    protected void setStudentService(IStudentService studentService){
        log.info("Resgist StudentService");
        this.studentService = studentService;
    }
    protected void unsetStudentService(IStudentService studentService){
        log.info("The cancellation of the IStudentService");
        if(studentService != this.studentService){
            return ;
        }
        this.studentService = null;
    }
    public static IStudentService getService(){
        return studentService;
    }
    /**
     *
     * @param ctxt
     */
    protected void deactivate(ComponentContext ctxt) {
        log.info("DEMO Student UI bundle is deactivated");
    }
}
