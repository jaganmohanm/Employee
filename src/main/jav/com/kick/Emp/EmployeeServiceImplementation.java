package com.kick.Emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






@Service

public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeRepository emprepo;
	@Transactional
	public List<Employee> getEmployee()
	{
		return (List<Employee>) emprepo.findAll();
	}
	@Transactional
    public void save(Employee emp)
	{
	emprepo.save(emp);
	}
	
	@Transactional
   public void delete(long id)
    {
    emprepo.deleteById(id);
   
    }
	@Transactional
	public void update(Employee emp,long id)
	{
		emprepo.save(emp);
	}
/*	@Transactional
	public void updateEmp(Employee emp, long id) {
		// TODO Auto-generated method stub
		emprepo.save(emp);
		
	}*/
	}
	
 
	

