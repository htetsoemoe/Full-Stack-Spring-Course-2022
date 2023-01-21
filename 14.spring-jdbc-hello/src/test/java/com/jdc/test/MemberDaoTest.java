package com.jdc.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;
import com.jdc.dao.MemberDao;
import com.jdc.dto.Member;

//@SpringJUnitConfig(locations = "classpath:/application-context.xml")

@SpringJUnitConfig(classes =  ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class MemberDaoTest {
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private JdbcOperations dbOperations;
	
	@Test
	@Sql("classpath:/database.sql")	// this annotation runs SQL before test method
	@Order(1)
	void test() {
		Member m = new Member();
		m.setLoginId("admin");
		m.setPassword("admin");
		m.setName("Admin");
		
		dao.create(m);
	}
	
	@Test
	@Order(2)
	void testUsingConnection() {
		var data = dbOperations.execute((Connection conn) -> {
			var stmt = conn.createStatement();
			var rs = stmt.executeQuery("select count(*) from member");
			while (rs.next()) {
				return rs.getLong(1);
			}
			return 0;
		});
		
		Assertions.assertEquals(1L, data);
	}
	
	@Test
	@Order(3)
	void testUsingStatement() {
		var data = dbOperations.execute((Statement stmt) -> {
			var rs = stmt.executeQuery("select count(*) from member");
			while (rs.next()) {
				return rs.getLong(1);
			}
			
			return 0;
		});
		
		Assertions.assertEquals(1L, data);
	}
	
	@Test
	@Order(4)
	void testUsingStatementUpdate() {
		var data = dbOperations.execute((Statement stmt) -> {
			return stmt.executeUpdate("""
					insert into member(loginId, password, name)
					values('Member', 'Member', 'Thaw Thaw')
					""");
		});
		Assertions.assertEquals(1, data);
	}
	
	@Test
	@Order(5)
	void testStaticQueryResultSetExtractor1() {
		var result = dbOperations.query("select count(*) from member", rs -> {
			while (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		});
		
		Assertions.assertEquals(2, result);
	}
	
	@Test
	@Order(6)
	void testStaticQueryResultSetExtractory2() {
		
		var list = dbOperations.query("select * from member", rs -> {
			var data = new ArrayList<Member>();
			
			while (rs.next()) {
				var m = new Member();
				m.setLoginId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setName(rs.getString(3));
				m.setPhone(rs.getString(4));
				m.setEmail(rs.getString(5));
				
				data.add(m);
			}
			return data;
		});
		
		Assertions.assertEquals(2, list.size());
	}
	
	@Test
	@Order(7)
	// RowCallbackHandler returns void
	void testStaticQueryRowCallbackHandler() {
		var list = new ArrayList<Member>();
		
		dbOperations.query("select * from member", rs -> {
			var m = new Member();
			m.setLoginId(rs.getString(1));
			m.setPassword(rs.getString(2));
			m.setName(rs.getString(3));
			m.setPhone(rs.getString(4));
			m.setEmail(rs.getString(5));
			
			list.add(m);	
		});
		
		Assertions.assertEquals(2, list.size());
	}
	
	@Test
	@Order(8)
	void testStaticQueryRowMapper() {
		var list = dbOperations.query("select * from member",
				(rs, no) -> {
					var m = new Member();
					m.setLoginId(rs.getString(1));
					m.setPassword(rs.getString(2));
					m.setName(rs.getString(3));
					m.setPhone(rs.getString(4));
					m.setEmail(rs.getString(5));
					return m;
				});
		
		Assertions.assertEquals(2, list.size());
	}
	
	
	
}
