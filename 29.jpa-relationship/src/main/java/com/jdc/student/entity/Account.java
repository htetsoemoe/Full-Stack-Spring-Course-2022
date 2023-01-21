package com.jdc.student.entity;

import java.awt.Color;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jdc.student.entity.converter.ColorConverter;

@Entity
@Table(name = "account")
@DiscriminatorColumn(name = "entity_type", columnDefinition = "char(1)")
//@Inheritance(strategy = JOINED)
public abstract class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable = false, length = 45)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(nullable = false, length = 10, name = "login_id")
	private String loginId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(name = "color")
	@Convert(converter = ColorConverter.class)
	private Color color;
	
	public Account() {
	}
	
	
	public Account(String name, String loginId, String password) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
	}


	public enum Role {
		Office, Teacher, Student
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
