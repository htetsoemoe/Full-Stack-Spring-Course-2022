package com.jdc.bean;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean {

	@Autowired
	private SimpleBean simpleBean;
	
	@PreDestroy
	void destroy() {
		simpleBean.release();
	}
}
