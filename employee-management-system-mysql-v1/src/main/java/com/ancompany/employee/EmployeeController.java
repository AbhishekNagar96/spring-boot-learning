package com.ancompany.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ancompany.employee.emperror.Emperror;
import com.ancompany.employee.emperror.EmperrorService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmperrorService emperrorService;
	
	private Emperror emperror=new Emperror();
	
	//get mappings
	@RequestMapping(method=RequestMethod.GET, value= "/employee")
	public List<Employee>getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/employee/{empid}")
	public Employee getEmployeeById(@PathVariable int empid){
		
		return employeeService.getEmployeeById(empid);
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/employee/by{deptname}")
	public List<Employee>getEmployeesByDept(@PathVariable String deptname){
		
		return employeeService.getEmployeesByDept(deptname);
	}
	
	//post mappings
	@RequestMapping(method=RequestMethod.POST, value= "/employee")
	public ResponseEntity<Emperror> addEmployee(@RequestBody Employee emp){
		
		if(emperrorService.checkforinvempid(emp.getEmpid()))
		{
			emperror.setEmperrorstatuscode(400);
			emperror.setEmperrorstatusmessage("invalid employee id");
			return new ResponseEntity<>(emperror,HttpStatus.BAD_REQUEST);
		}
		
		employeeService.addEmployee(emp);
		
		emperror.setEmperrorstatuscode(201);
		emperror.setEmperrorstatusmessage("created employee");
		return new ResponseEntity<>(emperror,HttpStatus.CREATED);
	}
	
	//put mappings
	@RequestMapping(method=RequestMethod.PUT, value= "/employee/{empid}")
	public ResponseEntity<Emperror> updateEmployee(@RequestBody Employee emp, @PathVariable int empid){
		
		if(emperrorService.checkforinvempid(empid))
		{
			emperror.setEmperrorstatuscode(200);
			emperror.setEmperrorstatusmessage("invalid employee id");
			return new ResponseEntity<>(emperror,HttpStatus.BAD_REQUEST);
		}
		
		employeeService.updateEmployeeById(emp, empid);
		
		emperror.setEmperrorstatuscode(200);
		emperror.setEmperrorstatusmessage("updated employee attendance");
		return new ResponseEntity<>(emperror,HttpStatus.OK);
	}
	
	// delete mappings
	@RequestMapping(method=RequestMethod.DELETE, value= "/employee")
	public ResponseEntity<Emperror> deleteAllEmployees(){
		
		employeeService.deleteAllEmployees();
		
		emperror.setEmperrorstatuscode(200);
		emperror.setEmperrorstatusmessage("deleted all employees");
		return new ResponseEntity<>(emperror,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/employee/{empid}")
	public ResponseEntity<Emperror> deleteEmployeeById(@PathVariable int empid){
		
		if(emperrorService.checkforinvempid(empid))
		{
			emperror.setEmperrorstatuscode(400);
			emperror.setEmperrorstatusmessage("invalid employee id");
			return new ResponseEntity<>(emperror,HttpStatus.BAD_REQUEST);
		}
		
		employeeService.deleteEmployeebyId(empid);
		
		emperror.setEmperrorstatuscode(200);
		emperror.setEmperrorstatusmessage("deleted employee");
		return new ResponseEntity<>(emperror,HttpStatus.OK);
	}
}
