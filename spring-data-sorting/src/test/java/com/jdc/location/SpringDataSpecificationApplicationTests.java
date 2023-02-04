package com.jdc.location;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jdc.location.model.entity.District;
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
	
	@Disabled
	@Test
	void test_district_spec_service() {
		var list = service.searchByRegion("West");
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	@Disabled
	@Test
	void test_search_by_region_sort() {
		var list = repo.searchByRegionSort("West", Sort.by("name").ascending());
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	@Disabled
	@Test
	void test_search_by_region_jpql_sort() {
		var list = repo.searchByRegionSort("West", Sort.by("name").descending());
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	@Disabled
	@Test
	void test_search_by_region_service_method() {
		var list = service.searchByRegionSort("Central", Sort.by("name"));
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	// creating & using 'Sort' object 
	@Test
	void test_search_by_region_creating_sort() {
		var typeSort = Sort.sort(District.class);
		
		var list = repo.searchByRegionSort("Central", typeSort.by(District::getName).descending());
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	

}
