package com.jdc.spring.demo;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	
	@Column(nullable = false)
	@Nonnull
	private String name;
	
	@Column(nullable = false)
	@Nonnull
	private String email;
	
	@Column(nullable = false)
	@Nonnull
	private String password;
	
	@Column(nullable = false)
	@Nonnull
	private Role role;
	
	@Version
	private Integer version;
	
	public enum Role {
		Admin, Member
	}

}
