package com.jdc.test;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.dao.mapper.MemberRowMapper;
import com.jdc.dto.Member;

@TestMethodOrder(OrderAnnotation.class)
@SpringJUnitConfig(locations = "/application-context.xml")
public class PreparedStatementTest {

	@Autowired
	private JdbcOperations jdbc;
	
	@Autowired
	private MemberRowMapper rowMapper;
	
	@Test
	@DisplayName("1. Select Single Data with Parameters")
	@Order(14)
	void test14() {
		
		var sql = "select count(*) from member where name like ?";
		var count = jdbc.queryForObject(sql, Integer.class, "Admin%");
		
		Assertions.assertEquals(1, count);
	}
	
	@Test
	@DisplayName("13. Select One with Parameters")
	@Order(13)
	void test13(@Value("${memeber.select.by.pk}") String sql) {
		var data = jdbc.queryForObject(sql, rowMapper, "admin");
		Assertions.assertNotNull(data);
		Assertions.assertEquals("Admin User", data.getName());
	}
	
	@Test
	@DisplayName("12. Select One with Parameters using ResultSetExtractory")
	@Order(12)
	void test12(@Value("${memeber.select.by.pk}") String sql) {
		ResultSetExtractor<Member> extractor = rs -> {
			
			while (rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			return null;
		};
		
		var data = jdbc.query(sql, extractor, "admin");
		
		Assertions.assertNotNull(data);
	}
	
	@Test
	@DisplayName("11. Select One with PreparedStatementSetter & ResultSetExtractor")
	@Order(11)
	void test11(@Value("${memeber.select.by.pk}") String sql) {
		var data = jdbc.query(sql, stmt -> stmt.setString(1, "admin"), rs -> {
			while (rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			return null;
		});
		
		Assertions.assertNotNull(data);
	}
	
	// This "JdbcTemplate query() >> (select and map from ResultSet to object)" method widely used in production
	@Test
	@DisplayName("10. Query with Parameters")
	@Order(10)
	void test10(@Value("${member.select.by.name}") String sql) {
		
		var list = jdbc.query(sql, rowMapper, "Admin%");
		Assertions.assertEquals(1, list.size());
	}
	
	// This "JdbcTemplate query() >> (select and map from ResultSet to object)" method widely used in production
	@Test
	@DisplayName("9. Query with PreparedStatementSetter")
	@Order(9)
	void test9(@Value("${member.select.by.name}") String sql) {
		
		var list = jdbc.query(sql, stmt -> stmt.setString(1, "Admin%"), rowMapper);
		Assertions.assertEquals(1, list.size());
	}
	
	
	// This "JdbcTemplate update() >> (insert, update and delete)" method widely used in production
	@Test
	@DisplayName("8. Update with Parameter")
	@Order(8)
	@Sql(scripts = "/database.sql")
	void test8(@Value("${member.insert}") String sql) {
		int count = jdbc.update(sql, "admin", "admin", "Admin User", "09441041264", "admin@gmail.com");
		Assertions.assertEquals(1, count);
	}
	
	@Test
	@DisplayName("7. Update with PreparedStatementSetter")
	@Order(7)
	@Sql(scripts = "/database.sql")
	void test7(@Value("${member.insert}") String sql) {
		
		int count = jdbc.update(sql, stmt -> {
			stmt.setString(1, "admin");
			stmt.setString(2, "admin");
			stmt.setString(3, "Admin User");
			stmt.setString(4, "09441041264");
			stmt.setString(5, "admin@gmail.com");
		});
		
		Assertions.assertEquals(1, count);
	}
	
	@Test
	@DisplayName("6. Execute with Simple SQL String")
	@Order(6)
	@Sql(scripts = "/database.sql")
	void test6(@Value("${member.insert}") String sql) {
		var count = jdbc.execute(sql, (PreparedStatement stmt) -> {
			stmt.setString(1, "admin");
			stmt.setString(2, "admin");
			stmt.setString(3, "Admin User");
			stmt.setString(4, "09441041264");
			stmt.setString(5, "admin@gmail.com");
			return stmt.executeUpdate();
		});
		
		Assertions.assertEquals(1, count);
	}
	
	@Test
	@DisplayName("5. Query with Creator for Select by Pk")
	@Order(5)
	void test5(@Qualifier("memberFindByPk") PreparedStatementCreatorFactory factory) {
		
		var result = jdbc.query(factory.newPreparedStatementCreator(List.of("member")), rs -> {
			while (rs.next()) {
				return rowMapper.mapRow(rs, 1);
			}
			return null;
		});
		
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Thaw Thaw", result.getName());
	}
	
	
	@Test
	@DisplayName("4. Query with Creator for Select Statement")
	@Order(4)
	void test4(@Qualifier("memberFindByNameLike") PreparedStatementCreatorFactory factory) {


		var result = jdbc.query(factory.newPreparedStatementCreator(List.of("Admin%")), rowMapper);

		Assertions.assertEquals(1, result.size());
	}


	@Test
	@DisplayName("3. Execute with Creator for Select Statement")
	@Order(3)
	void test3(@Qualifier("memberFindByNameLike") PreparedStatementCreatorFactory factory) {

		var result = jdbc.execute(factory.newPreparedStatementCreator(List.of("Admin%")), stmt -> {
			List<Member> list = new ArrayList<>();

			var rs = stmt.executeQuery();

			while (rs.next()) {
				var m = new Member();
				m.setLoginId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setName(rs.getString(3));
				m.setPhone(rs.getString(4));
				m.setEmail(rs.getString(5));

				list.add(m);
			}

			return list;
		});

		Assertions.assertEquals(1, result.size());
	}

	@Test
	@DisplayName("2. Execute with Creator for Update Statement")
	@Order(2)
	void test2(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {
		PreparedStatementCreator creator = factory
				.newPreparedStatementCreator(List.of("member", "member", "Thaw Thaw", "09441041265", "thaw@gmail.com"));

		var count = jdbc.update(creator);

		Assertions.assertEquals(1, count);
	}

	@Test
	@DisplayName("1. Execute with Creator for Insert Statement")
	@Order(1)
	@Sql(scripts = "/database.sql")
	void test1(@Qualifier("memberInsert") PreparedStatementCreatorFactory factory) {

		PreparedStatementCreator creator = factory
				.newPreparedStatementCreator(List.of("admin", "admin", "Admin User", "09441041264", "admin@gmai.com"));

		var count = jdbc.execute(creator, PreparedStatement::executeUpdate);

		Assertions.assertEquals(1, count);
	}
	
	
/*
	@Value("${member.insert}") // In test method, @Value annotation can use in test method parameter 
	String sql;
	@Test
	@DisplayName("1. Execute with PreparedStatement Creator")
	@Order(1)
	@Sql(scripts = "/database.sql")
	void test1() {
		var count = jdbc.execute((Connection conn) -> {
			var stmt = conn.prepareStatement(sql);

			stmt.setString(1, "admin");
			stmt.setString(2, "admin");
			stmt.setString(3, "Admin User");
			stmt.setString(4, "09441041264");
			stmt.setString(5, "admin@gmail.com");

			return stmt;

		}, PreparedStatement::executeUpdate);

		Assertions.assertEquals(1, count);
	}
*/


}
