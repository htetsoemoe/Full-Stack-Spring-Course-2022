package com.jdc.bean.di;

public class EmployeeService {
	
	private EmployeeDao dao;

	public EmployeeService(EmployeeDao dao) {
		super();
		this.dao = dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	public void create(Employee e) {
		dao.insert(e);
	}

}
