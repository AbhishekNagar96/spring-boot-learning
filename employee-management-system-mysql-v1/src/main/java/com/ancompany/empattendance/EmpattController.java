package com.ancompany.empattendance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ancompany.empattendance.empatterrorobj.Empatterror;
import com.ancompany.empattendance.empatterrorobj.EmpatterrorService;

@RestController
public class EmpattController {
	
	@Autowired
	private EmpattService empattService;
	
	@Autowired
	private EmpatterrorService empatterrorService;
	
	private Empatterror empatterror= new Empatterror();
	
	//get mappings
	
	/*@RequestMapping(method=RequestMethod.GET, value="/emp/empatt")
	public List<Empattendance> getAllEmpatt(){
		return empattService.getAllEmpatt();
	}*/
	
	@RequestMapping(method=RequestMethod.GET, value="/emp/{empid}/empatt")
	public ResponseEntity<List<Empattendance>> getEmpattByEmpId(@PathVariable int empid){
		
		System.out.println("The number of absent days in current month is "+(30-empattService.getleavecount()));
		
	/*	if(empatterrorService.checkforinvalidempid(empid))
		{
			empatterror.errorcode=400;
			empatterror.statusmessage="invalid employee id";
			
			List<Empatterror> el= new ArrayList<>();
			el.add(empatterror);
			return new ResponseEntity<>(el,HttpStatus.BAD_REQUEST);
		}
	*/	
		return new ResponseEntity<>(empattService.getEmpattByEmpId(empid),HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/emp/{empid}/empatt/{attid}")
	public Empattendance getEmpattByAttId(@PathVariable int attid){
		
		return empattService.getEmpattByAttId(attid);
	}
	
	//post mappings
	@RequestMapping(method=RequestMethod.POST, value="/emp/{empid}/empatt")
	public ResponseEntity<Empatterror>addEmpatt(@RequestBody Empattendance empatt, @PathVariable int empid){
		
		if(empatterrorService.checkforinvalidempid(empid))
		{
			empatterror.setErrorcode(400);
			empatterror.setStatusmessage("invalid employee id");
			return new ResponseEntity<>(empatterror,HttpStatus.BAD_REQUEST);
		}
		empattService.addEmpatt(empatt);
		
		empatterror.setErrorcode(201);
		empatterror.setStatusmessage("created employee attendance");
		return new ResponseEntity<>(empatterror,HttpStatus.CREATED);
	}
	
	//put mappings
	@RequestMapping(method=RequestMethod.PUT, value="/emp/{empid}/empatt/{attid}")
	public ResponseEntity<Empatterror> updateEmpattById(@RequestBody Empattendance empatt, @PathVariable int attid){
		
		if(empatterrorService.checkforinvalidattid(attid))
		{
			empatterror.setErrorcode(200);
			empatterror.setStatusmessage("invalid attendance id");
			return new ResponseEntity<>(empatterror,HttpStatus.BAD_REQUEST);
		}
		
		empattService.updateEmpattById(empatt, attid);
		
		empatterror.setErrorcode(200);
		empatterror.setStatusmessage("updated employee attendance");
		return new ResponseEntity<>(empatterror,HttpStatus.OK);
	}
	
	//delete mappings
	@RequestMapping(method=RequestMethod.DELETE, value="/emp/{empid}/empatt")
	public ResponseEntity<Empatterror> deleteAllEmpatt(@PathVariable int empid){
		
		if(empatterrorService.checkforinvalidempid(empid))
		{
			empatterror.setErrorcode(400);
			empatterror.setStatusmessage("invalid employee id");
			return new ResponseEntity<>(empatterror,HttpStatus.BAD_REQUEST);
		}
		
		empattService.deleteAllEmpatt();
		
		empatterror.setErrorcode(200);
		empatterror.setStatusmessage("deleted employee attendance");
		return new ResponseEntity<>(empatterror,HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/emp/{empid}/empatt/{attid}")
	public ResponseEntity<Empatterror> deleteEmpattByEmpId(@PathVariable int attid){
		
		if(empatterrorService.checkforinvalidattid(attid))
		{
			empatterror.setErrorcode(400);
			empatterror.setStatusmessage("invalid employee attendance id");
			return new ResponseEntity<>(empatterror,HttpStatus.BAD_REQUEST);
		}
		
		empattService.deleteEmpattByEmpid(attid);
		
		empatterror.setErrorcode(200);
		empatterror.setStatusmessage("deleted employee attendance");
		return new ResponseEntity<>(empatterror,HttpStatus.OK);	
	}
	
}
