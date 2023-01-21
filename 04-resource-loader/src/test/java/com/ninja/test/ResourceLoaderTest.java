package com.ninja.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ninja.config.AppConfig;

@SpringJUnitConfig(classes = AppConfig.class)
public class ResourceLoaderTest {

	@Autowired
	ResourcePatternResolver resolver;
	
	@Test
	void test_load_resource() {
		var sql = resolver.getResource("classpath:/insert.sql");
		assertNotNull(sql);
		
		assertTrue(sql.exists());
		
		try(var br = new BufferedReader(new InputStreamReader(sql.getInputStream()))) {
			String line = null;
			
			while (null != (line = br.readLine())) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void test_resource_pattern() {
		try {
			var list = resolver.getResources("classpath*:/**/*.sql");
			System.out.println(list.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
