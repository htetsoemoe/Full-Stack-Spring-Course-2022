package com.jdc.student.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.jdc.student.entity.embeddable.Contact;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String address;

	private Contact contact;

	@AttributeOverrides({
			@AttributeOverride(name = "phone", column = @Column(name = "sec_phone", length = 16, table = "address")),
			@AttributeOverride(name = "email", column = @Column(name = "sec_email", table = "address")) })
	private Contact secondary;

	@MapsId
	@OneToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getSecondary() {
		return secondary;
	}

	public void setSecondary(Contact secondary) {
		this.secondary = secondary;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
