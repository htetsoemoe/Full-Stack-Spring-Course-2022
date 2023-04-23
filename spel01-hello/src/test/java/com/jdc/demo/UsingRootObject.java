package com.jdc.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class UsingRootObject {
	
	ExpressionParser parser;
	
	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}
	
	@Test
	void using_root_object() {
		var student = new Student("Thaw Thaw", 27, List.of("Accounting", "Cooking", "Traveling", "Movies"));
		
		var expression = parser.parseExpression("name");
		
		var name = expression.getValue(student, String.class);
		assertEquals("Thaw Thaw", name);
		
		// if root object has setters but there is no setValue for record
		if (expression.isWritable(student)) {
			expression.setValue(student, "TMMA");
		}
		
		expression = parser.parseExpression("age");
		var age = expression.getValue(student, Integer.class);
		assertEquals(27, age);
		
		expression = parser.parseExpression("'First Interest : ' + interests[0]");
		var firstInterest = expression.getValue(student, String.class);
		assertEquals("First Interest : Accounting", firstInterest);
	}
	
	@Test
	void using_record_as_root_object() {
		Address address = new Address("Thitsar Street", "No.21/A", "Chan Mya Tharzi Township");
		
		var expression = parser.parseExpression("street");
		var street = expression.getValue(address, String.class);
		assertEquals(address.street(), street);
		
		expression = parser.parseExpression("building");
		var building = expression.getValue(address, String.class);
		assertEquals(address.building(), building);
	}

}
