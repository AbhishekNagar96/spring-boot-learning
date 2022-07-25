package com.ancompany.employee;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {
	
	@Id
//	@Column(name="empid")
	int empid;
	
//	@Column(name="empname")
	String empname;
	
//	@Column(name="deptname")
	String deptname;
	
//	@Column(name="empemail")
	String empemail;
	
	//constructors	
	public Employee() {

	}
	
	public Employee(int empid, String empname, String deptname, String empemail) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.deptname = deptname;
		this.empemail = empemail;
	}

	//getters and setters
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

}
