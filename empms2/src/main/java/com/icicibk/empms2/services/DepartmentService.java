package com.icicibk.empms2.services;

import java.util.List;
import java.util.Optional;

import com.icicibk.empms2.dto.Department;

public interface DepartmentService {
	
	public Department addDepartment(Department department);
	public String deleteDepartmentById(String deptId);
	public String updateDepartment(String deptId,Department department);
	public Optional<Department>getDepartmentById(String deptId);
	public List<Department> getDepartments();

}
