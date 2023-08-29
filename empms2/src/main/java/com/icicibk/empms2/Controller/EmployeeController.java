package com.icicibk.empms2.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icicibk.empms2.dto.Department;
import com.icicibk.empms2.dto.Employee;
import com.icicibk.empms2.exceptions.IdNotFoundException;
import com.icicibk.empms2.payload.request.EmployeeRequest;
import com.icicibk.empms2.services.DepartmentService;
import com.icicibk.empms2.services.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
//	http methods. : to retrieve the data put: modify post: to create a new entry delete
//	but who will help us to read the data from request body. ?
//	@ RequestBody : read the data and transfrom to java object
//	xml ==> java
//	json ==> java
	@PostMapping("/createEmp")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest) throws IdNotFoundException {
		
//		if deptId doest exists then create it add the records
//		else exists then use that object
		
		Optional<Department> optional = departmentService.getDepartmentById(employeeRequest.getDepartmentId());
		
		if(optional.isPresent()) {
		Employee employee2 = new Employee(employeeRequest.getEmpId(),
				                          employeeRequest.getDoj(),
				                          employeeRequest.getEmpFirstName(),
				                          employeeRequest.getEmpLastName(),
				                          employeeRequest.getEmpAddress(),
				                          employeeRequest.getEmpSalary(),
				                          employeeRequest.getAge(),
				                          employeeRequest.getEmpContact(),
				                          optional.get());
				
		return new ResponseEntity(employeeService.addEmployee(employee2),HttpStatus.CREATED);
		}
		else {
			Map<String,String> map = new HashMap<>();
			map.put("exception", "record not found");
			map.put("status", "404");
			return new ResponseEntity(map,HttpStatus.NOT_FOUND) ;
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String empId,@RequestBody EmployeeRequest employeeRequest) throws IdNotFoundException{
		
    Optional<Department> optional = departmentService.getDepartmentById(employeeRequest.getDepartmentId());
		
		if(optional.isPresent()) {
		Employee employee2 = new Employee(employeeRequest.getEmpId(),
				                          employeeRequest.getDoj(),
				                          employeeRequest.getEmpFirstName(),
				                          employeeRequest.getEmpLastName(),
				                          employeeRequest.getEmpAddress(),
				                          employeeRequest.getEmpSalary(),
				                          employeeRequest.getAge(),
				                          employeeRequest.getEmpContact(),
				                          optional.get());
				
		return new ResponseEntity(employeeService.addEmployee(employee2),HttpStatus.CREATED);
		}
		else {
			Map<String,String> map = new HashMap<>();
			map.put("exception", "record not found");
			map.put("status", "404");
			return new ResponseEntity(map,HttpStatus.NOT_FOUND) ;
		}
//		return ResponseEntity.ok(empId);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") String empId) throws IdNotFoundException{
		
		employeeService.deleteEmployeeById(empId);
		
		return ResponseEntity.noContent().build();
	}
	

}
