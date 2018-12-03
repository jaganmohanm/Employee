package com.kick.Emp;

import java.util.List;



public interface EmployeeService {
	public List<Employee> getEmployee();
	public void save(Employee emp);
	public void update(Employee emp,long id);
	
	public void delete(long id);
	
	//public void updateEmp(Employee emp, long id);
	
}
