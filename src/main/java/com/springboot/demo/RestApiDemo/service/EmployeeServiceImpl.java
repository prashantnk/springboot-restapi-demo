package com.springboot.demo.RestApiDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.RestApiDemo.dao.EmployeeRepository;
import com.springboot.demo.RestApiDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//	@Autowired
//	@Qualifier("employeedaoJPAImpl")
//	private Employeedao employeedao;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
//	@Transactional
	public List<Employee> findAll() {
//		return employeedao.findAll();
		return employeeRepository.findAll();
	}

	@Override
//	@Transactional
	public Employee getEmployee(int id) {
//		return employeedao.getEmployee(id);
		Optional<Employee> e = employeeRepository.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	@Override
//	@Transactional
	public void saveEmployee(Employee e) {
//		employeedao.saveEmployee(e);
		employeeRepository.save(e);
	}

	@Override
//	@Transactional
	public void deleteEmployee(int id) {
//		employeedao.deleteEmployee(id);
		employeeRepository.deleteById(id);
	}

}
