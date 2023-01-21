package com.jdc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.JpaConfiguration;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State.Type;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
		"/init-tables.sql",
		"/load-data.sql"
})
public class StateRepoTest {
	
	@Autowired
	private StateRepo repo;
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	void find_by_state(Type type, int size) {
		var result = repo.findByType(type); 
		assertThat(result, hasSize(size));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"State,7",
		"Region,7",
		"Union,1"
	})
	@Transactional
	void test_stream_by_type(Type type, long size) {
		Stream<State> result = repo.streamByType(type);
		assertThat(result.count(), is(size));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Lower,3",
		"Center,0"
	})
	void test_count_by_region(String region, long size) {
		var result = repo.countByRegion(region);
		assertThat(result, is(size));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Lower,true",
		"Center,false"
	})
	void test_existsby_region(String region, boolean expected) {
		var result = repo.existsByRegion(region);
		assertThat(result, is(expected));
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {
			"Yangon", "Mandalay"
	})
	void test_find_one(String name) {
		var result = repo.findOneByName(name);
		assertThat(result, notNullValue());
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"Region,7",
		"State,7",
		"Union,1"
	})
	void test_distinct(Type type, int size) {
		var result = repo.findDistinctByType(type);
		assertThat(result, hasSize(size));
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {
		"Region", "State", "Union"
	})
	void test_removeby_type(Type type) {
		repo.removeByType(type);
		var result = repo.countByType(type);
		assertThat(result, is(0L));
	}
	
	@ParameterizedTest
	@CsvSource({
		"Region,3",
		"State,3",
		"Union,1"
	})
	void test_limit(Type type, int size) {
		var result = repo.findTop3ByType(type);
		assertThat(result, hasSize(size));
	}
}
