package com.jdc.shop.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Feature implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String feature;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

}
