package com.github.demo.em;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import com.github.demo.Department;

@ManagedBean
@RequestScoped
public class MyController {

    private static final Logger LOG = Logger.getLogger(MyController.class);

    @EJB
    private MyService myService;

    public MyController() {
        LOG.info("MyController is being created");
    }

    public void save() {
        Department department = new Department();
        department.setName("technology");
        myService.save(department);
    }

    public void update() {
        myService.update(1, "accounting");
    }

    public void delete() {
        myService.delete(3);
    }

    public void read() {
        myService.getDepartments();
    }
}
