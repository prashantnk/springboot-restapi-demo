package com.springboot.demo.RestApiDemo.dao;

import java.util.List;

import com.springboot.demo.RestApiDemo.entity.Employee;

public interface Employeedao {
	public List<Employee> findAll();

	public Employee getEmployee(int id);

	public void saveEmployee(Employee e);

	public void deleteEmployee(int id);

}
