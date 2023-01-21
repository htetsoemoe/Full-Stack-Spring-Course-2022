package com.jdc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import com.jdc.dto.Result;

@Aspect
@Configuration
public class MyConcerns {
	
	@Pointcut("bean(myService)")
	void myServiceBean() {
		
	}
	
	@Before(value = "myServiceBean() && args(value,*)", argNames = "value")
	void beforeLog(String value) {
		System.out.println("Before Execution");
		System.out.println("Value is %s.".formatted(value));
	}
	
	@AfterReturning(
				pointcut = "myServiceBean() && execution(com.jdc..Result *(..)) && args(name,count)",
				argNames = "result,name,count",
				returning = "result"
			)
	void afterReturning(Result result, String name, int count) {
		System.out.println("After Returning");
		
		System.out.println("Arg Name  : %s.".formatted(name));
		System.out.println("Arg Value : %d.".formatted(count));
		
		System.out.println(result);
	}
	
	@AfterThrowing(
			pointcut = "myServiceBean() && args(a,b)",
			argNames = "ex,a,b",
			throwing = "ex")
	void afterThrowing(RuntimeException ex, int a, int b) {
		System.out.println("After throwing an exception.");
		
		System.out.println("Argument A : %s.".formatted(a));
		System.out.println("Argument B : %s.".formatted(b));
		
		System.out.println(ex.getClass().getName());
		System.out.println(ex.getMessage());
	}
	
	@After(value = "myServiceBean() && args(*,number)", argNames = "number")
	void afterAll(int number) {
		System.out.println("After Finally");
		System.out.println("Count is %d.".formatted(number));
	}

	@Around(value = "myServiceBean() && args(value,count)", argNames = "value,count")
	Object aroundInvoke(ProceedingJoinPoint joinPoint, String value, int count) {
		Object result = null;
		
		System.out.println("Around Before Invoking");
		
		System.out.println("Value is %s.".formatted(value));
		System.out.println("Count is %d.".formatted(count));
		
		try {
			result = joinPoint.proceed();
			System.out.println("Around After Returning");
		} catch (Throwable e) {
			System.out.println("Around After Throwing an exception");
			throw new RuntimeException(e);
		} finally {
			System.out.println("Around Finally");
		}
		
		return result;
	}
}
