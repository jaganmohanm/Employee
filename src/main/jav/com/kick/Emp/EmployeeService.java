package com.kick.Emp;

import java.util.List;





public interface EmployeeService {
	public List<Employee> getEmployee();
	
	public void save(Employee emp);
}
