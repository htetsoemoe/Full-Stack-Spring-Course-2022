package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.query.entity.Product;

public class ProductTest extends AbstractTest{

	@ParameterizedTest
	@CsvSource({
		"fo,2",
		"foo,2",
		"foods,2",
		"foodd,0"
	})
	void find_by_category_name_like(String category, int count) {
		var query = em.createNamedQuery("Product.findByCategoryNameLike", Product.class);
		query.setParameter("name", category.toLowerCase().concat("%"));
		
		var result = query.getResultList();// Execute a SELECT query and return the query resultsas a typed List.
		assertEquals(count, result.size());
	}
}
