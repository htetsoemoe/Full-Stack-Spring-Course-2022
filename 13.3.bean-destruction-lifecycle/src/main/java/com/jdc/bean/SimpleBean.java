package com.jdc.bean;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;



public class SimpleBean implements DisposableBean{
	
	public void release() {
		System.out.println("Release Method for Configuration.");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean :: destroy()");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Using @PreDestroy Method.");
	}

}
