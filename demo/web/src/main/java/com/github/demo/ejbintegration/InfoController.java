package com.github.demo.ejbintegration;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;

import org.apache.log4j.Logger;

import com.github.demo.Department;
import com.github.demo.em.MyService;

import lombok.Data;

@Data
@ManagedBean
@RequestScoped
public class InfoController {

    private static final Logger LOG = Logger.getLogger(InfoController.class);

    private long selectedItem;

    private HtmlDataTable table;

    @EJB
    private MyService myService;

    public InfoController() {
        LOG.info("INJECTED FIELD: " + myService);
    }

    @PostConstruct
    public void ini() {
        LOG.info("INJECTED FIELD: " + myService);
        departments = myService.listDepartments();
    }

    private List<Department> departments;

    public void selectDepartment() {
        Department department = (Department) table.getRowData();
        LOG.info("selected-value: " + department.getId() + ": " + department.getName());
    }

    public void ok() {
        LOG.info("selected-item: " + selectedItem);
    }
}
