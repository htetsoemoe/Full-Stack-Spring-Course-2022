package com.jdc.location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.services.StateCriteriaService;
import com.jdc.location.model.services.StateSpecServices;

@SpringBootTest
class SpringDataSpecificationApplicationTests {
	
	@Autowired
	private StateCriteriaService service;
	
	@Autowired
	private StateSpecServices stateSpeService;

	@Test
	@Disabled
	void test_criteria_qurey() {
		var result = service.findByRegion("East");
		assertThat(result, hasSize(2));
	}
	
	@Test
	void test_specification_api() {
		var result = stateSpeService.findByRegion("East");
		assertThat(result, hasSize(2));
	}

}
