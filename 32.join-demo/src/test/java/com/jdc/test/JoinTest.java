package com.jdc.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.entity.Category;
import com.jdc.entity.Product;

@TestMethodOrder(OrderAnnotation.class)
public class JoinTest extends AbstractTest{
	
	/**
	 * ManyToOne and OneToMany -> Default join is left join but @ManyToOne(optional = false) join type is inner join.
	 */
	@Order(1)
	@Test
	void test_many_to_one() {
		var data = em.find(Product.class, 1);
		System.out.println("Category ID : %d, Category Name : %s".formatted(data.getCategory().getId(), data.getCategory().getName()));
	}
	
	/**
	 * OneToMany -> default fetch mode is Lazy, if fetch mode is eager hibernate will use left inner join
	 */
	@Order(2)
	@Test
	void test_default_one_to_many() {
		var category = em.find(Category.class, 1);
		System.out.println(category.getName());
		
		category.getProduct().stream()
				.map(Product::getName)
				.forEach(System.out::println);
	}
	
	@Order(3)
	@Test
	void test_to_one_jpql_join() {
		var jpql = "select p from Product p join p.category c where c.name = :name"; // there is no join default in left outer join
		
		var query = em.createQuery(jpql, Product.class);
		query.setParameter("name", "Foods");
		
		var list = query.getResultList();
		list.stream().map(Product::getName).forEach(System.out::println);
	}
	
	@Order(4)
	@Test
	void test_to_many_jpql_join() {
		var jpql = "select p from Product p join p.supplier s where s.name = :supplier";// many to many must be write join
		var query = em.createQuery(jpql, Product.class);
		query.setParameter("supplier", "196 store");
		
		var list = query.getResultList();
		list.stream().map(Product::getName).forEach(System.out::println);
	}	
}
