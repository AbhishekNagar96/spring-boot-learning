package com.ancompany.employee.emperror;

import org.springframework.stereotype.Service;

@Service
public class EmperrorService {
	
	public boolean checkforinvempid(int empid) {
		if(empid>1000 || empid<=0)
		{
			return true;
		}
		return false;
	}

}
