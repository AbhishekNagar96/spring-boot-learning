package com.ancompany.empattendance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmpattRepository extends CrudRepository<Empattendance,Integer>{
	
	public List<Empattendance> findByEmpEmpid(int empId);
	
	@Query("SELECT COUNT(*) FROM Empattendance r WHERE r.attstatus='present'")
	public int getleaves();

}
