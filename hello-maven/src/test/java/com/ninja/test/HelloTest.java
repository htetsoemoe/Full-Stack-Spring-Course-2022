package com.ninja.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ninja.maven.Course;
import com.ninja.maven.CourseInsert;

public class HelloTest {
	
	public static ClassPathXmlApplicationContext IOC_CONTAINER;
	
	@BeforeAll
	public static void initialize() {
		IOC_CONTAINER = new ClassPathXmlApplicationContext("classpath:/app-config.xml");
	}
	
	
	@AfterAll
	public static void close() {
		IOC_CONTAINER.close();
	}

	
	@Test
	void test() {
		var c = new Course();
		c.setName("Full Stack Spring");
		c.setFees(250000);
		c.setDuration(6);
		
		var courseInsert = IOC_CONTAINER.getBean("insert", CourseInsert.class);
		courseInsert.insert(c);
		
	}

}
//public static String URL = "jdbc:mysql://localhost:3306/hello_maven";
//public static String USER = "root";
//public static String PASSWORD = "admin";


//
//var dataSource = new MysqlDataSource();
//dataSource.setURL(URL);
//dataSource.setUser(USER);
//dataSource.setPassword(PASSWORD);
//
//var insert = new CourseInsert(dataSource);
//insert.insert(c);
//