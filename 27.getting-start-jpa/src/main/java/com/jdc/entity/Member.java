package com.jdc.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "MEMBER_TBL")
@SecondaryTables({
	@SecondaryTable(name = "LOGIN_INFO",
			indexes = {
					@Index(columnList = "role")
			}),
	@SecondaryTable(name = "CONTACT_INFO",
			uniqueConstraints = @UniqueConstraint(columnNames = "email")
			)
})
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "member_seq")
	@SequenceGenerator(name = "member_seq", allocationSize = 1, initialValue = 2000)
	private int id;
	private String name;
	private Date dateOfBirth;

	@Column(table = "LOGIN_INFO")
	private String loginId;
	@Column(table = "LOGIN_INFO")
	private String password;
	@Column(table = "LOGIN_INFO")
	private Role role;

	@Embedded
	private Contact contact;

	public enum Role {
		Admin, Teacher, Student
	}

	public Member() {

	}

	public Member(String name, String phone, String email, String address) {
		Contact contact = new Contact();
		this.name = name;
		contact.setEmail(email);
		contact.setPhone(phone);
		contact.setAddress(address);
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
