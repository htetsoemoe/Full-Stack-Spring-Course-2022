package com.jdc.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.services.StateSpecServices;

@SpringBootTest
public class JoinTest {
	
	@Autowired
	private StateSpecServices service;
	
	@Test
	void test_root_join() {
		var list = service.findByDistrictNameLike("Ma");
		
		for(var dto : list) {
			System.out.println(dto);
		}
	}

}
