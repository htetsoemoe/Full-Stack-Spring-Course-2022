package com.jdc.location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.services.StateCriteriaService;

@SpringBootTest
class SpringDataSpecificationApplicationTests {
	
	@Autowired
	private StateCriteriaService service;

	@Test
	void test_criteria_qurey() {
		var result = service.findByRegion("East");
		assertThat(result, hasSize(2));
	}

}
