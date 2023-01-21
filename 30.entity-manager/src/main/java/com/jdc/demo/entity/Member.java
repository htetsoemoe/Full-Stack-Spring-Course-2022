package com.jdc.demo.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jdc.demo.entity.listeners.TimeEnableEntity;
import com.jdc.demo.entity.listeners.TimeListener;
import com.jdc.demo.entity.listeners.Times;

@Entity
@Table(name = "member")
@EntityListeners(TimeListener.class)
public class Member implements TimeEnableEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String loginId;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "member", orphanRemoval = true, cascade = { PERSIST, MERGE, REMOVE, DETACH })
	private List<Contact> contacts;
	
	private Times times;

	public enum Role {
		Admin, Member
	}
	
	public Member() {
		contacts = new ArrayList<>();
	}
	
	
	public Member(String name, String loginId, String password) {
		this();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.role = Role.Member;
	}
	

	public Times getTimes() {
		return times;
	}

	public void setTimes(Times times) {
		this.times = times;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public void addContact(Contact c) {
		c.setMember(this);
		contacts.add(c);
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
