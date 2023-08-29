package com.icicibk.empms2.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Department implements Serializable{
	
	@NotEmpty
	private String deptName;
	@Id
	private String deptId;
	@NotNull
	private int headSize;
	@NotEmpty
	private String location;
	@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private Set<Employee> employees;
	
	public Department(String deptId) {
		super();
		this.deptId = deptId;
	}	

}
