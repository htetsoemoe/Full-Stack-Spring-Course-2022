package com.jdc.location;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.repo.DistrictRepo;
import com.jdc.location.model.services.DistrictSpecService;

@SpringBootTest
class SpringDataSpecificationApplicationTests {
	
	@Autowired
	private DistrictRepo repo;
	
	@Autowired
	private DistrictSpecService service;
	
	@Disabled
	@Test
	void test_search_by_state_regions() {
		var list = repo.findByStateRegionOrderByName("Central");
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	@Test
	void test_district_spec_service() {
		var list = service.searchByRegion("West");
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	

}
