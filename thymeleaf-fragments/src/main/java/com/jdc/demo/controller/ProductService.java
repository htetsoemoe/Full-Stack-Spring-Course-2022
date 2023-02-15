package com.jdc.demo.controller;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public List<Product> findAll() {
		return List.of(
				new Product(1, "Product 1", "product1.jpg"),
				new Product(2, "Product 2", "product2.jpg"),
				new Product(3, "Product 3", "product3.jpg"),
				new Product(4, "Product 4", "product4.jpg"),
				new Product(5, "Product 5", "product5.jpg"),
				new Product(6, "Product 6", "product6.jpg"),
				new Product(7, "Product 7", "product7.jpg"),
				new Product(8, "Product 8", "product8.jpg")
				);
	}
}
