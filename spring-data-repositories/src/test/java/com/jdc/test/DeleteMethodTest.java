package com.jdc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.location.config.JpaConfiguration;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State.Type;
import com.jdc.location.model.repo.StateRepo;

@SpringJUnitConfig(classes = JpaConfiguration.class)
@Sql(scripts = {
		"/init-state.sql",
		"/load-data.sql"
})
public class DeleteMethodTest {
	
	@Autowired
	private StateRepo repo;
	
	@Disabled
	@ParameterizedTest
	@CsvSource(
			delimiter = '\t',
			value = {
					"1	Ayeyarwady	Region	Lower	Pathein	6184829	14"
			}
	)
	void test_delete_by_entity(int id, String name, Type type, String region, String capital, int porpulation, long remains) {
		// create entity object
		var state = new State(id, name, type, region, capital, porpulation);
		
		// execute 'Delete Method'
		repo.delete(state);
		
		// check result
		assertThat(repo.count(), is(remains));
	}
	
	@Disabled
	@ParameterizedTest
	@CsvSource({
		"1,14"
	})
	void test_delete_by_id(int id, long remain) {
		repo.deleteById(id);
		
		assertThat(repo.count(), is(remain));
	}
	
	@Disabled
	@Test
	void test_delete_all() {
		repo.deleteAll();
		assertThat(repo.count(), is(0L));
	}
	
	@Disabled
	@Test
	void test_delete_all_in_batch() {
		repo.deleteAllInBatch();
		assertThat(repo.count(), is(0L));
	}
	
	@Disabled
	@ParameterizedTest
	@MethodSource("idsForDelete")
	void test_delete_all_by_ids(List<Integer> ids, long remain) {
		repo.deleteAllById(ids);
		assertThat(repo.count(), is(remain));
	}
	
	@Disabled
	@ParameterizedTest
	@MethodSource("idsForDelete")
	void test_delete_all_by_ids_in_batch(List<Integer> ids, long remain) {
		repo.deleteAllByIdInBatch(ids);
		assertThat(repo.count(), is(remain));
	}
	
	
	static Stream<Arguments> idsForDelete() {
		return Stream.of(
				Arguments.of(List.of(1,2,3), 12),
				Arguments.of(List.of(1,2,3,4,5,6), 9)
		);
	}
	
	@ParameterizedTest
	@MethodSource("entitiesForDelete")
	void test_delete_all_by_entities(List<State> states, long remain) {
		repo.deleteAll(states);
		assertThat(repo.count(), is(remain));
	}
	
	
	static Stream<Arguments> entitiesForDelete() {
		return Stream.of(
					Arguments.of(
							List.of(
								new State(1, "Ayeyarwady", Type.Region, "Lower", "Pathein", 6184829)	
							),
							14
					),
					Arguments.of(
							List.of(
									new State(2, "Bago", Type.Region, "Lower", "Bago", 4867373),
									new State(3, "Chin", Type.State, "West", "Hakha", 478801)
							),
							13
					)
			);
	}

	/*
	@Disabled
	@ParameterizedTest
	@CsvSource(
			delimiter = '\t',
			value = "1,3,5	12"
	)
	void test_delete_all_by_ids(String ids, long remain) {
		var arrayStr = ids.split(",");
		var idList = Arrays.stream(arrayStr).map(item -> Integer.parseInt(item)).toList();
		
		repo.deleteAllById(idList);
		
		assertThat(repo.count(), is(remain));
	}
	
	@ParameterizedTest
	@CsvSource(
			delimiter = '\t',
			value = "1,3,5	12"
	)
	void test_delete_all_by_ids_in_batch(String ids, long remain) {
		var arrayStr = ids.split(",");
		var idList = Arrays.stream(arrayStr).map(Integer::parseInt).toList();
		
		repo.deleteAllByIdInBatch(idList);
		
		assertThat(repo.count(), is(remain));
	}
	*/

}
