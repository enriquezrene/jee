package com.github.demo.binding;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import com.github.demo.Department;

@ManagedBean
@RequestScoped
public class BindingController {

    private static final Logger LOG = Logger.getLogger(BindingController.class);

    private String name;
    private Department department;

    public BindingController() {
        department = new Department();
    }

    public void ok() {
        LOG.info("name: " + name);
        LOG.info("Department values: " + department.getId() + "@" + department.getName());
    }

    public void setName(String name) {
        LOG.info("set name");
        this.name = name;
    }

    public void setDepartment(Department department) {
        LOG.info("set dep");
        this.department = department;
    }

    public String getName() {
        LOG.info("get name");
        return this.name;
    }

    public Department getDepartment() {
        LOG.info("get dep");
        return this.department;
    }
}
