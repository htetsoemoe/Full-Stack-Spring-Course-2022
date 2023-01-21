package com.jdc.test.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class TestConfig {
	
	@Bean
	DataSource dataSource() {
		var ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/stu_db");
		ds.setUser("root");
		ds.setPassword("admin");
		return ds;		
	}
	
	@Bean
	DbUtils dbUtils() {
		return new DbUtils();
	}

}
