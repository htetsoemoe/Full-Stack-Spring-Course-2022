package com.jdc.bean.di;

public class EmployeeDao {
	public void insert(Employee e) {
		System.out.println("""
				Employee Name : %s,
				Email : %s
				""".formatted(e.getName(), e.getEmail()));
	}
}
