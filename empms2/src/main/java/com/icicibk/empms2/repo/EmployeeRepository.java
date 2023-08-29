package com.icicibk.empms2.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icicibk.empms2.dto.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	

}
