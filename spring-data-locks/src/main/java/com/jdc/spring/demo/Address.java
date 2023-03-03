package com.jdc.spring.demo;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Type type;
	
	@Nonnull
	private String building;
	@Nonnull
	private String street;
	@Nonnull
	private String zipcode;
	
	@Version
	private int version;
	
	public enum Type {
		Primary, Secondary
	}

}
