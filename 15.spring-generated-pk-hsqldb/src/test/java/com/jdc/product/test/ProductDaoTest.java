package com.jdc.product.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.product.config.ApplicationConfig;
import com.jdc.product.model.dao.CategoryDao;
import com.jdc.product.model.dao.ProductDao;
import com.jdc.product.model.dto.Product;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class ProductDaoTest {

	@Autowired
	private ProductDao pDao;
	
	@Autowired
	private CategoryDao cDao;

	@Test
	@DisplayName("1. Create Product")
	@Order(1)
	@Sql(statements = {
			"insert into category (name) values ('Foods')",
			"insert into category (name) values ('Drinks')"
	})
	void test1() {
		var category = cDao.findById(1);
		var product = new Product();
		product.setCategory(category);
		product.setName("Pizza");
		product.setPrice(12000);
		
		var id = pDao.create(product);
		assertEquals(1, id);
	}
	
	@Test
	@Order(2)
	@DisplayName("2. Find Product by Id")
	void test2() {
		var p = pDao.findById(1);
		assertNotNull(p);
		
		assertEquals("Pizza", p.getName());
		assertEquals("Foods", p.getCategory().getName());
		assertEquals(12000, p.getPrice());
		
		assertNull(pDao.findById(2));
	}
	
	@Test
	@Order(3)
	@DisplayName("3. Find Products by Category")
	void test3() {
		List<Product> list = pDao.findByCategoryId(1);
		assertEquals(1, list.size());
		assertTrue(pDao.findByCategoryId(2).isEmpty());
	}
	
	@Test
	@Order(4)
	@DisplayName("4. Search")
	void test4() {
		assertEquals(1, pDao.search("Foods").size());
		assertEquals(1, pDao.search("PIZZA").size());
		assertTrue(pDao.search("Pizzas").isEmpty());	// This test is called "Boundary Test".
	}
	
	@Test
	@Order(5)
	@DisplayName("5. Update Product")
	void test5() {
		var p = pDao.findById(1);
		p.setName("Italian Pizza");
		p.setPrice(15000);
		
		int count = pDao.update(p);
		assertEquals(1, count);
		
		var other = pDao.findById(1);
		assertEquals(p.getName(), other.getName());
		assertEquals(p.getPrice(), other.getPrice());
	}
	
	@Test
	@Order(6)
	@DisplayName("6. Delete Product")
	void test6() {
		int count = pDao.delete(1);
		assertEquals(1, count);
		assertNull(pDao.findById(1));
	}
}
