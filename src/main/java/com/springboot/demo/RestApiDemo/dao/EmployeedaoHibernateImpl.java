package com.springboot.demo.RestApiDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.RestApiDemo.entity.Employee;

@Repository
public class EmployeedaoHibernateImpl implements Employeedao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		Session currSession = entityManager.unwrap(Session.class);
		String hql = "from Employee ";
		Query<Employee> q = currSession.createQuery(hql, Employee.class);
		System.out.println("hibernate called!");
		return q.getResultList();
	}

	@Override
	public Employee getEmployee(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		return currSession.get(Employee.class, id);
	}

	@Override
	public void saveEmployee(Employee e) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(e);
	}

	@Override
	public void deleteEmployee(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.delete(currSession.get(Employee.class, id));
	}

}
