package com.github.demo.em;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.github.demo.Department;

@Stateless
public class MyService {

    private static final Logger LOG = Logger.getLogger(MyService.class);

    public MyService() {
        LOG.info("CREANDO INSTANCIA....");
    }

    @PersistenceContext(unitName = "")
    private EntityManager em;

    public void save(Department department) {
        em.persist(department);
    }

    public void update(long departmentId, String newName) {
        Department department = em.find(Department.class, departmentId);
        department.setName(newName);
        em.merge(department);
    }

    public void delete(long departmentId) {
        Department department = em.find(Department.class, departmentId);
        em.remove(department);
    }

    public void getDepartments() {
        List<Department> departments = em.createQuery("SELECT d FROM Department d").getResultList();
        for (Department department : departments) {
            LOG.info(department.getId() + ": " + department.getName());
        }

        List<Object[]> departmentsArray = em.createNativeQuery("select * from tbl_department").getResultList();
        for (Object[] array : departmentsArray) {
            LOG.info(array[0] + ": " + array[1]);
        }
    }

    public List<Department> listDepartments() {
        return em.createQuery("SELECT d FROM Department d").getResultList();
    }
}
