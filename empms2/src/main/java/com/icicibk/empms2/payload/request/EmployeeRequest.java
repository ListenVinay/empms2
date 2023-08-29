package com.icicibk.empms2.payload.request;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icicibk.empms2.dto.Department;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequest {
	
	@NotBlank
	private String empId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate doj;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
//    private LocalDateTime doj2;
    @NotEmpty(message = "emp_first name should not be blank")
	private String empFirstName;
    @NotEmpty
	private String empLastName;
    @NotEmpty
	private String empAddress;
    @NotNull(message = "float value should be provided")
    @DecimalMin("2.0")
	private float empSalary;
    
    @Min(value = 18)
    @Max(value = 140)
    private int age;
    
	@Column(unique = true)
	private String empContact;

	private String departmentId;
	

}
