package com.jdc.location;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.services.StateCriteriaService;
import com.jdc.location.model.services.StateSpecServices;

@SpringBootTest
public class DeleteByRegionTest {
	
	@Autowired
	private StateCriteriaService stateCriteriaService;
	
	@Autowired
	private StateSpecServices stateSpecService;
	
	@Disabled
	@Test
	void test_criteria_delete_by_region_test() {
		var count = stateCriteriaService.deleteByRegion("East");
		assertThat(count, is(2L));
	}
	
	@Test
	void test_specification_delete_by_region() {
		var count = stateSpecService.deleteByRegion("East");
		assertThat(count, is(2L));
	}

}
