package com.ancompany.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	// for get requests
	public List<Employee> getAllEmployees() {
		List<Employee> emp= new ArrayList<>();
		employeeRepository.findAll().forEach(emp::add);
		return emp;
	}
	
	public Employee getEmployeeById(int empid) {
		return employeeRepository.findById(empid).get();
	}
	
	public List<Employee> getEmployeesByDept(String deptname) {
		List<Employee> emp= new ArrayList<>();
		employeeRepository.findAllByDeptname(deptname).forEach(emp::add);
		return emp;
	}
	
	// for post requests
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
	}
	
	// for put requests
	public void updateEmployeeById(Employee emp, int empid) {
		employeeRepository.save(emp);
	}
	
	// for delete requests
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}
	
	public void deleteEmployeebyId(int empid) {
		employeeRepository.deleteById(empid);
	}

}
