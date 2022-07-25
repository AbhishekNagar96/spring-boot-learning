package com.ancompany.employee.emperror;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emperror {
	
	@Id
	private int emperrorstatuscode;
	private String emperrorstatusmessage;

	// constructors
	public Emperror() {
		
	}
	
	public Emperror(int emperrorstatuscode, String emperrorstatusmessage) {
		super();
		this.emperrorstatuscode = emperrorstatuscode;
		this.emperrorstatusmessage = emperrorstatusmessage;
	}
	
	//getters and setters
	public int getEmperrorstatuscode() {
		return emperrorstatuscode;
	}

	public void setEmperrorstatuscode(int emperrorstatuscode) {
		this.emperrorstatuscode = emperrorstatuscode;
	}

	public String getEmperrorstatusmessage() {
		return emperrorstatusmessage;
	}

	public void setEmperrorstatusmessage(String emperrorstatusmessage) {
		this.emperrorstatusmessage = emperrorstatusmessage;
	}
	
}
