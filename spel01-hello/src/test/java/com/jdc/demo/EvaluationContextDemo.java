package com.jdc.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class EvaluationContextDemo {
	ExpressionParser parser;

	@BeforeEach
	void init() {
		parser = new SpelExpressionParser();
	}

	@Test
	void demo() {
		Address address = new Address("56A street", "No.21/A", "Chanmyatharzi");

		var expression = parser.parseExpression("building + ', ' + street + ', ' + township");

		// using simple evaluation context
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().withRootObject(address).build();
		
		var result = expression.getValue(context, address, String.class);
		
		System.out.println(result);
	}
}
