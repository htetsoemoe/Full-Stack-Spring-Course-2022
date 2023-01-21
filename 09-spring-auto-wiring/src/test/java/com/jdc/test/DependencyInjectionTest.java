package com.jdc.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.student.config.AppConfig;
import com.jdc.student.dao.CourseDao;
import com.jdc.student.dto.Course;
import com.jdc.student.dto.Course.Level;
import com.jdc.test.db.DbUtils;

@SpringJUnitConfig(classes = {
		AppConfig.class, DbUtils.class
})
@TestMethodOrder(value = OrderAnnotation.class)
public class DependencyInjectionTest {
	
	@Autowired
	private CourseDao dao;

	@Autowired
	private DbUtils dbUtils;
	
	@BeforeEach
	void init() {
		dbUtils.truncate("course");
	}
	
	@Test
	@Order(1)
	void test_insert() {
		// Get New Course
		Course course = getJavaBasicCourse();
		
		// Insert Course
		int id = dao.insert(course);
		
		Assertions.assertEquals(1, id);
	}

	@Test
	@Order(2)
	void test_find_by_id() {
		
		dbUtils.execute("""
				insert into course(name, level, fees, month)
				values('Java Basic', 0, 150000, 6);
				""");
		
		Course course = dao.findById(1);
		Course expected = getJavaBasicCourse();
		expected.setId(1);
		
//		 System.out.println(course.getId() + course.getName() + course.getLevel() + course.getMonths() + course.getFees()); 
//		 System.out.println(expected);
//		 System.out.println(course.equals(expected));
		 		
		Assertions.assertEquals(course, expected);
	}
	
	private Course getJavaBasicCourse() {
		var course = new Course();
		course.setName("Java Basic");
		course.setLevel(Level.Basic);
		course.setFees(150000);
		course.setMonths(6);
		return course;
	}
}
