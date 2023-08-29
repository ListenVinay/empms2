package com.icicibk.empms2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icicibk.empms2.dto.Department;
import com.icicibk.empms2.services.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/create")
	public Department createDepartment(@Valid @RequestBody Department department) {
		
		return departmentService.addDepartment(department);
		
	}

}
