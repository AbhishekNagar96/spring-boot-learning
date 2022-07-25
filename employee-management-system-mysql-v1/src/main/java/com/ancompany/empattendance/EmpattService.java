package com.ancompany.empattendance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpattService {

	@Autowired
	private EmpattRepository empattRepository;
	
	//for get requests
/*	public List<Empattendance> getAllEmpatt(){
		List<Empattendance> empatt=new ArrayList<>();
		empattRepository.findAll().forEach(empatt::add);
		return empatt;
	}*/
	
	public int getleavecount() {
		return empattRepository.getleaves();
	}
	
	public List<Empattendance> getEmpattByEmpId(int empid) {
		
		List<Empattendance> empatt= new ArrayList<>();
		empattRepository.findByEmpEmpid(empid).forEach(empatt::add);
		
		return empatt;
	}
	
	public Empattendance getEmpattByAttId(int attid) {
		return empattRepository.findById(attid).get();
	}
	
	//for post requests
	public void addEmpatt(Empattendance empatt) {
		empattRepository.save(empatt);
	}
	
	//for put requests
	public void updateEmpattById(Empattendance empatt,int attid) {
		empattRepository.save(empatt);
	}
	
	//for delete requests
	public void deleteAllEmpatt() {
		empattRepository.deleteAll();
	}
	
	public void deleteEmpattByEmpid(int attid) {
		empattRepository.deleteById(attid);
	}
	
}
