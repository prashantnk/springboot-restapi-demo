package com.springboot.demo.RestApiDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.RestApiDemo.entity.Employee;
import com.springboot.demo.RestApiDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmp() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee e) {
		e.setId(0);
		employeeService.saveEmployee(e);
		return e;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee e) {
		employeeService.saveEmployee(e);
		return e;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {

		Employee e = employeeService.getEmployee(id);
		if (e == null)
			return "Bad Request !";

		employeeService.deleteEmployee(id);

		return "deleted employee with id : " + id;
	}
}
