package com.springboot.demo.RestApiDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.RestApiDemo.entity.Employee;

@Repository
public class EmployeedaoJPAImpl implements Employeedao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> q = entityManager.createQuery("from Employee", Employee.class);
		System.out.println("JPA called!");
		return q.getResultList();
	}

	@Override
	public Employee getEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void saveEmployee(Employee e) {
		Employee dbEmp = entityManager.merge(e);
		e.setId(dbEmp.getId());
	}

	@Override
	public void deleteEmployee(int id) {
//		TypedQuery<Employee> q = entityManager.createQuery("delete from Employee where id = :theId", Employee.class);
//		q.setParameter("theId", id);
//		System.out.println("JPA delete called!");
//		q.executeUpdate();
		entityManager.remove(entityManager.find(Employee.class, id));
	}

}
