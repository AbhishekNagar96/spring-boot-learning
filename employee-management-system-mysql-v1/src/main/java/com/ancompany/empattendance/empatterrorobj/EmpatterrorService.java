package com.ancompany.empattendance.empatterrorobj;

import org.springframework.stereotype.Service;

@Service
public class EmpatterrorService {
	
	public boolean checkforinvalidempid(int empid) {
		if(empid>1000 || empid<=0)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkforinvalidattid(int attid) {
		if(attid>(100*30) || attid<=0)
		{
			return true;
		}
		return false;
	}

}
