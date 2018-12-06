package com.kick.Emp;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ExceptionHandling.EmployeeException;
import ExceptionHandling.*;

@RestController
@RequestMapping(value = { "/employee" })
public class Controller {
	@Autowired
	EmployeeService empService;
	ResponseDetails resp = new ResponseDetails();

	// insertingEmployeeDetails

	@PostMapping(value = "/createEmployee", headers = "Accept=application/json", produces = "application/json")
	public ResponseEntity createUser(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		String status = "201";
		String message = "Employee created successfully";
		System.out.println("Creating Employee " + employee.getName());
		empService.createEmployee(employee);
		resp.setStatus("Success");
		resp.setMessage("Employee details inserted successfully!");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(employee.getid()).toUri());
		return new ResponseEntity<>(resp, headers, HttpStatus.CREATED);

	}

	// getAllEmployees
	@GetMapping(value = { "/getAllEmployees" }, headers = "Accept=application/json", produces = "application/json")
	public List<Employee> getAllUser() {
		List<Employee> tasks = empService.getEmployee();
		System.out.println("------------------------------");
		int j = 0;
		Iterator i = tasks.iterator();
		while (i.hasNext()) {
			System.out.println(tasks.get(j).getid() + " | " + tasks.get(j).getName());
			if (i.next() == "")
				break;
			else
				j++;
		}
		return tasks;

	}

	// getEmployeeById
	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Employee> getUserById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Optional<Employee> employee = empService.findById1(id);
		if (employee == null) {

			return employee;
		}
		return employee;
	}

	// deletEmployeeById
	@DeleteMapping(value = "/deleteById/{id}", headers = "Accept=application/json")
	public ResponseEntity deleteEmployee(@PathVariable("id") long id) {
		
		Optional<Employee> employee = empService.findById1(id);
		if(employee!=null)
		{
			
			empService.deleteEmployeeById(id);
		try {
		if (employee != null) {
			throw new EmployeeException("Deletion is not possible");
		}
		resp.setStatus("Success");
		resp.setMessage("Deleted successfully!");
		return new ResponseEntity<>(resp,HttpStatus.OK);
		
		}
		catch(EmployeeException ex)
		{
			resp.setMessage(ex.getMessage());
		}
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
			
			}
		
		
		return null;
		
	}
	// updateById

	@PutMapping(value = "/updateEmployee/{id}", headers = "Accept=application/json")
	public ResponseEntity updateUser(@PathVariable("id") long id, @RequestBody Employee currentEmp) {
		Optional<Employee> employee = empService.findById1(id);
try {
		if (employee == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
}
catch(EmployeeException ex)
{
	throw new EmployeeException("");
	}
		empService.update(currentEmp, id);
		return new ResponseEntity(HttpStatus.OK);
	}

	/*
	 * // insertion
	 * 
	 * @RequestMapping("/insert") public ModelAndView create() { return new
	 * ModelAndView("create"); }
	 * 
	 * @RequestMapping("/insertionSuccess") public List<Employee>
	 * success(HttpServletRequest req, Employee emp) { String name =
	 * req.getParameter("name"); String country = req.getParameter("country");
	 * emp.setCountry(name); emp.setCountry(country); empService.save(emp);
	 * List<Employee> task = empService.getEmployee(); return task;
	 * 
	 * }
	 * 
	 * // delete
	 * 
	 * @RequestMapping("/delete") public ModelAndView del() { return new
	 * ModelAndView("delete"); }
	 * 
	 * @RequestMapping(value = "/deleteemp") public List<Employee>
	 * deletee(HttpServletRequest req, Employee emp) { String idd =
	 * req.getParameter("id"); int id = Integer.parseInt(idd);
	 * empService.delete(id); List<Employee> task = empService.getEmployee(); return
	 * task; }
	 * 
	 * // update
	 * 
	 * @RequestMapping("/update") public ModelAndView update() { return new
	 * ModelAndView("update"); }
	 * 
	 * @RequestMapping("/updateemp") public List<Employee> update(HttpServletRequest
	 * req, Employee emp) {
	 * 
	 * String name = req.getParameter("name"); String country =
	 * req.getParameter("country"); String id = req.getParameter("id"); int i =
	 * Integer.parseInt(id); emp.setCountry(country); emp.setName(name);
	 * emp.setid(i); empService.update(emp, i); List<Employee> task =
	 * empService.getEmployee(); return task; }
	 * 
	 */

}
