package com.ninja.maven;

import java.sql.SQLException;

import javax.sql.DataSource;

public class CourseInsert {
	
	private static final String SQL = "insert into course(name, fees, duration) values(?,?,?)";
	
	private DataSource dataSource;

	public CourseInsert(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	public void insert(Course c) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SQL)) {
			
			stmt.setString(1, c.getName());
			stmt.setInt(2, c.getFees());
			stmt.setInt(3, c.getDuration());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
