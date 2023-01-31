package com.jdc.location;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.location.model.services.DistrictSpecService;

@SpringBootTest
public class DistrictSpecServiceTest {
	
	@Autowired
	private DistrictSpecService service;
	
	@Test
	void service_search_method_in_production() {
		var list = service.search("Central", null, "Mandalay");
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}

/*
 * 
Hibernate: 
    select
        d1_0.id,
        d1_0.name,
        d1_0.state_id 
    from
        district d1_0 
    join
        state s1_0 
            on s1_0.id=d1_0.state_id 
    where
        s1_0.region=? 
        and lower(d1_0.name) like ?
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
        s1_0.id=?
Mandalay	
 */
	
	
	@Disabled
	@Test
	void service_search_or_method() {
		var list = service.search("Mandalay");
		for(var dto : list) {
			System.out.println(dto.getName());
		}
	}
	
	/*
Hibernate: 
    select
        d1_0.id,
        d1_0.name,
        d1_0.state_id 
    from
        district d1_0 
    join
        state s1_0 
            on s1_0.id=d1_0.state_id 
    where
        lower(d1_0.name) like ? 
        or lower(s1_0.name)=? 
        or lower(s1_0.region)=? 
        or lower(s1_0.capital)=?
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
        s1_0.id=?
Kyaukse
Mandalay
Meiktila
Myingyan
Nyaung-U
Pyinoolwin
Yamethin
	 */

}
