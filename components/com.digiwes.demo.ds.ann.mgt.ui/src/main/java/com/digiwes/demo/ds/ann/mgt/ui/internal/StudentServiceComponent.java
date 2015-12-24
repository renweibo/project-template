package com.digiwes.demo.ds.ann.mgt.ui.internal;


import com.digiwes.demo.ds.ann.mgt.service.IStudentService;
import org.apache.log4j.Logger;
import org.osgi.service.component.ComponentContext;


/**
 * @scr.component name="demo.student.component" immediate=true
 * @scr.reference name="demo.student.default"
 *                interface="com.digiwes.demo.ds.ann.mgt.service.IStudentService" cardinality="1..1"
 *                policy="dynamic" bind="setStudentService" unbind="unsetStudentService"
 */
public class StudentServiceComponent {
    private static Logger log = Logger.getLogger(StudentServiceComponent.class);
    private static IStudentService studentService;

    protected void activate(ComponentContext ctxt) {

    }

    /**
     * 注册服务
     * @param studentService
     */
    public void setStudentService(IStudentService studentService){
        log.info("Resgist StudentService");
        this.studentService = studentService;
    }

    /**
     * 注销服务
     * @param studentService
     */
    public void unsetStudentService(IStudentService studentService){
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
       log.debug("DEMO Person Management bundle is deactivated");
    }
}
