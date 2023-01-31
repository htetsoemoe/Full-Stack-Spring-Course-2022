package com.jdc.location;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.services.SubQueryDemoService;

@SpringBootTest
public class SubQueryDemoServiceTest {
	
	@Autowired
	private SubQueryDemoService service;
	
	@Test
	void sub_query_service_test() {
		var list = service.search("mo");
		
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	/*
	 * 
	Hibernate: 
    select
        s1_0.id,
        s1_0.capital,
        s1_0.name,
        s1_0.porpulation,
        s1_0.region,
        s1_0.type 
    from
        state s1_0 
    where
        s1_0.id in((select
            d1_0.state_id 
        from
            district d1_0 
        where
            lower(d1_0.name) like ?))
Kachin
Sagaing
Shan
	 */

}
