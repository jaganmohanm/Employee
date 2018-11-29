package com.kick.Emp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;





@RestController
@RequestMapping(value= {"/emp"})
public class Controller {
	@Autowired
	EmployeeService empService;
	
	
	
	@RequestMapping("/insert")
	public ModelAndView create()
	{
		return new ModelAndView("create");
	}
	
	@RequestMapping("/insertionSuccess")
	public List<Employee> success(HttpServletRequest req,Employee emp)
	{
		String name=req.getParameter("name");
		//int id=Integer.parseInt(req.getParameter("id").toString());
		//System.out.println(id);
		emp.setName(name);
		//emp.setid(id);
		empService.save(emp);
		List<Employee> task=empService.getEmployee();
		return task;
		
	}
	
	
	@GetMapping(value= {"/get"}, headers="Accept=application/json")
	 public List<Employee>  getAllUser() {	
		System.out.println("Reached controller GET method");
	  List<Employee> tasks=empService.getEmployee();
	
	  int j=0;
	  Iterator i=tasks.iterator();
		 while(i.hasNext())
		 {
		 
	System.out.println(tasks.get(j).getid()+"   "+tasks.get(j).getName());
			if(i.next()=="")
	{
		break;
	}
	else
		  j++;
	
	}
	  return tasks;
	
	 }

	
	
	 
	 
	

}
