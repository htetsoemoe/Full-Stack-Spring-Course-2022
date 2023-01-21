package com.jdc.service;

import org.springframework.stereotype.Service;

import com.jdc.dto.Result;

@Service
public class MyService {

	public Result service(String name, int count) {
		System.out.println("My service method running.....");
		return new Result(name, count);
	}
	
	public int divided(int a, int b) {
		return a/b;
	}
}
