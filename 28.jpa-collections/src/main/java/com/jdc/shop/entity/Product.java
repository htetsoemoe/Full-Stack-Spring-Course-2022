package com.jdc.shop.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OrderColumn;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	
	
	@ElementCollection
	@CollectionTable(name = "PRODUCT_PRICES", joinColumns = @JoinColumn(name = "product", referencedColumnName = "id"))
	@MapKeyColumn(name = "priceKey")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<PriceType, Integer> price;
	
	@ElementCollection
	@CollectionTable(name = "PRODUCT_TAGS", joinColumns = @JoinColumn(name = "product"))
	@OrderColumn(name = "view_tags")
	private List<String> tags;
	
	@ElementCollection
	@CollectionTable(name = "FEATURE", joinColumns = @JoinColumn(name = "product"))
	private Set<Feature> feature;

	private enum PriceType {
		Customer, Agent, Purchase
	}
	
	public Set<Feature> getFeature() {
		return feature;
	}

	public void setFeature(Set<Feature> feature) {
		this.feature = feature;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<PriceType, Integer> getPrice() {
		return price;
	}

	public void setPrice(Map<PriceType, Integer> price) {
		this.price = price;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
