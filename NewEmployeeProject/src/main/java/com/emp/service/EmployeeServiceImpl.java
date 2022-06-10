package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.exceptions.DuplicateEmpIdException;
import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository edao;

	@Override
	public List<Employee> getEmployee() {
		return edao.findAll();
	}

	@Override
	public String updateEmployee(Employee employee) {
		edao.save(employee);
		return "Employee Updated ";

	}

	@Override
	public String createEmployee(Employee employee)  throws  DuplicateEmpIdException{
		Employee emp = edao.getById(employee.getEmployeeId());
		if(emp.getEmployeeId()==employee.getEmployeeId()) {
			throw new DuplicateEmpIdException("Employee with "+employee.getEmployeeId()+" already Exist");
		}else {
			edao.save(employee);
		    return "Employee Added";
		}
		
		
	}

	@Override
	public String deleteEmployee(int empId) {
		Employee em = edao.getById(empId);
		edao.delete(em);
		return "Employee Deleted";
		
	}
	

}


