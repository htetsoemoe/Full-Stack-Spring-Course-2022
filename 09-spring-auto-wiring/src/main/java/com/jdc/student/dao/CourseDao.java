package com.jdc.student.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jdc.student.dto.Course;
import com.jdc.student.dto.Course.Level;

@Component
public class CourseDao {
	
	private static final String INSERT_INTO = """
			insert into course(name, level, month, fees) values(?, ?, ?, ?)
			""";
	private static final String FIND_BY_ID = "select * from course where id = ?";
	
	@Autowired
	private DataSource dataSource;	
	
	/*
	 * @Autowired 
	 * public CourseDao(DataSource dataSource) { 
	 * 		this.dataSource = dataSource; 
	 * }
	 */
	public int insert(Course course) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(INSERT_INTO, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getLevel().ordinal());
			stmt.setInt(3, course.getMonths());
			stmt.setInt(4, course.getFees());
			
			var result = stmt.executeUpdate();
			
			if (result > 0) {
				var resultSet = stmt.getGeneratedKeys();
				
				while (resultSet.next()) {
					return resultSet.getInt(1);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Course findById(int id) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(FIND_BY_ID)) {
			
			stmt.setInt(1, id);
			
			var resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				var course = new Course();
				course.setId(resultSet.getInt("id"));
				course.setName(resultSet.getString("name"));
				course.setLevel(Level.values()[resultSet.getInt("level")]);
				course.setMonths(resultSet.getInt("month"));
				course.setFees(resultSet.getInt("fees"));//******
				
				return course;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
