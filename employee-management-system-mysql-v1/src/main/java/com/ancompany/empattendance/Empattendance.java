package com.ancompany.empattendance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.ancompany.employee.Employee;

@Entity
//@Table(name="Empattendance")
public class Empattendance {
	
	@Id
//	@Column(name="attid")
	int attid;
	
//	@Column(name="attstatus")
	String attstatus;
	
	@ManyToOne
	private Employee emp;

	//constructors
	public Empattendance() {
		
	}
	
	public Empattendance(int attid, String attstatus, int empid) {
		super();
		this.attid = attid;
		this.attstatus = attstatus;
		this.emp = new Employee(empid,"","","");
	}
	
	//getters and setters
	public int getAttid() {
		return attid;
	}

	public void setAttid(int attid) {
		this.attid = attid;
	}

	public String getAttstatus() {
		return attstatus;
	}

	public void setAttstatus(String attstatus) {
		this.attstatus = attstatus;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
