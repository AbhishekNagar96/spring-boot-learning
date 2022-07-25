package com.ancompany.empattendance.empatterrorobj;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empatterror {
	
	@Id
	private int empattstatuscode;   // not recommended way of using statuscode as id
	private String statusmessage;
	
	//constructors
	public Empatterror() {
	}
	
	public Empatterror(int errorcode, String statusmessage) {
		super();
		this.empattstatuscode = errorcode;
		this.statusmessage = statusmessage;
	}
	
	//getters and setters
	public int getErrorcode() {
		return empattstatuscode;
	}
	public void setErrorcode(int errorcode) {
		this.empattstatuscode = errorcode;
	}
	public String getStatusmessage() {
		return statusmessage;
	}
	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}

}
