package com.jdc.student.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jdc.student.dao.CourseDao;
import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@ComponentScan(basePackages = "com.jdc.student.dao")
public class AppConfig {
	
	@Bean
	DataSource dataSource() {
		var ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/stu_db");
		ds.setUser("root");
		ds.setPassword("admin");
		return ds;
	}
	
	/*
	 * @Bean CourseDao courseDao() { return new CourseDao(); }
	 */

}
