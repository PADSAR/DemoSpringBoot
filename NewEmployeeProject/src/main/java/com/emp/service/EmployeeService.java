package com.emp.service;

import com.emp.exceptions.DuplicateEmpIdException;
import com.emp.model.Employee;
import java.util.List;

public interface EmployeeService  {
	
	public List<Employee> getEmployee();
	public String updateEmployee(Employee employee);
	public String createEmployee(Employee employee) throws DuplicateEmpIdException;
	public String deleteEmployee(int empId);
	
}
