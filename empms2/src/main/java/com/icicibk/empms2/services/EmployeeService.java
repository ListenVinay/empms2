package com.icicibk.empms2.services;

import java.util.List;
import java.util.Optional;

import com.icicibk.empms2.dto.Employee;
import com.icicibk.empms2.exceptions.IdNotFoundException;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public void deleteEmployeeById(String empId) throws IdNotFoundException;
	public String updateEmployee(String empId,Employee employee);
	public Optional<Employee>getEmployeeById(String empId);
	public List<Employee> getEmployees();

}
