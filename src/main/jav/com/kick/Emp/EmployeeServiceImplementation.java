package com.kick.Emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeRepository emprepo;
	
	public List<Employee> getEmployee()
	{
		System.out.println("Reached employee service");
		//System.out.println((List<Employee>)emprepo.findAll());
		return (List<Employee>) emprepo.findAll();
	}
	public void save(Employee emp)
	{
		
		emprepo.save(emp);
	}
}
