package com.icicibk.empms2.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // this class will be used for ORM mapping.

public class Employee {
	
	    @Id
		private String empId;
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    @JsonFormat(pattern = "MM/dd/yyyy")
	    private LocalDate doj;
//	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//	    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
//	    private LocalDateTime doj2;
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
		@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn(name = "dept_id", nullable = false)
//		@OnDelete(action = OnDeleteAction.CASCADE)
		@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
		private Department department;
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
					+ ", empAddress=" + empAddress + ", empSalary=" + empSalary + ", empContact=" + empContact;
		}
		
		// by default it will create the columns on the basis of field name.
		// 
		

}
