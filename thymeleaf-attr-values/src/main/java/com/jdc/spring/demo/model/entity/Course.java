package com.jdc.spring.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter course name")
	@Column(nullable = false, unique = true)
	private String name;
	
	@NotBlank(message = "Please enter course level.")
	@Column(nullable = false, unique = true)
	private Level level;
	private int months;
	private int fees;
	private String remark;
	
	
	public enum Level {
		Basic, Intermediate, Advance
	}
}
