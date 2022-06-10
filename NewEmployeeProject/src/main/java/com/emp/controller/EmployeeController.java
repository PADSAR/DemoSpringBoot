package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.exceptions.DuplicateEmpIdException;
import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService emps;
	
	public EmployeeController(EmployeeService emps) {
		super();
		this.emps = emps;
	}
	@RequestMapping(value = "/getEmp",produces ="application/json")
	public List<Employee> getAllEmployee(){
		List<Employee> emp=emps.getEmployee();
		return emp;
		
	}
	@PutMapping(path = "{empId}", consumes = "application/json")
	public void updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee employee) {
		 emps.updateEmployee(employee);
		 
	}
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	throws DuplicateEmpIdException {
		emps.createEmployee(employee);
		throw new DuplicateEmpIdException("id exist");
		
	
	}
	@DeleteMapping(path = "{empId}", produces = "application/json")
	public String deleteEmployeeById(@PathVariable("empId") int empId){
			emps.deleteEmployee(empId);
			return empId +"Employee details deleted";
			
	}
}

























/*public class EmployeeController {
	
	@Autowired
	private EmpService empservice;
	
	@GetMapping(value = "/gettempdatails",produces ="application/json")
	List<Employee> getEmployees(){
		List<Employee> empList=empservice.getAllEmployees();
		return empList;
	}
	
	@PostMapping(value = "/savemap",consumes ="application/json",produces = "application/json")
	ResponseEntity<Employee> createEmployee(@RequestBody Employee e){
		int id=empservice.createEmployee(e);
		System.out.println("Employee with id "+id+" has been created");
		return ResponseEntity.ok(e);
	}

}
*/