package com.icicibk.empms2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icicibk.empms2.dto.Department;
import com.icicibk.empms2.repo.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public String deleteDepartmentById(String deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDepartment(String deptId, Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Department> getDepartmentById(String deptId) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(deptId);
	}

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

}
