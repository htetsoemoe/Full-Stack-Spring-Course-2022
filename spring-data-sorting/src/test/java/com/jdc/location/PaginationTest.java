package com.jdc.location;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.jdc.location.model.repo.DistrictRepo;
import com.jdc.location.model.services.DistrictSpecService;

@SpringBootTest
public class PaginationTest {

	@Autowired
	private DistrictRepo repo;

	@Autowired
	private DistrictSpecService service;

	@Disabled
	@Test
	void test_pagination_district_repo() {
		var pageParam = PageRequest.of(0, 5, Sort.by("name"));
		
		// Using JPQL method
		//var result = repo.searchByRegion("East", pageParam);
		
		// Using Naming Rule method
		var result = repo.findByStateRegion("East", pageParam);

		System.out.printf("Elements					: %d%n", result.getTotalElements());
		System.out.printf("Pages	 				: %d%n", result.getTotalPages());
		System.out.printf("Current Page element	 	: %d%n", result.getNumber());

		var elements = result.toList();
		for (var dto : elements) {
			System.out.println(dto.getName());
		}
	}

	@Test
	void test_pagination_district_service() {
		var pageParam = PageRequest.of(0, 5, Sort.by("name"));

		var result = service.searchByRegion("East", pageParam);

		System.out.printf("Elements				: %d%n", result.getTotalElements());
		System.out.printf("Pages	 			: %d%n", result.getTotalPages());
		System.out.printf("Current Page Element	: %d%n", result.getNumber());

		var elements = result.toList();
		for (var dto : elements) {
			System.out.println(dto.getName());
		}
	}

}
