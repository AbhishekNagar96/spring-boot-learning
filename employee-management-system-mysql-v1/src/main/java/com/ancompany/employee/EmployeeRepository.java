package com.ancompany.employee;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	
	List<Employee> findAllByDeptname(String deptname);

}
