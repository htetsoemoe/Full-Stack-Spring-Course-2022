package com.jdc.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MethodAccessAspect {
	
	public void beforeExecution(JoinPoint joinPoint) {
		
	}
	
	public void afterReturning(JoinPoint joinPoint) {
		
	}
	
	public void afterThrowing(JoinPoint joinPoint) {
		
	}
	
	public void afterFinally(JoinPoint joinPoint) {
		
	}
	
	public Object aroundInvocation(ProceedingJoinPoint proceedJoinPoint) {
		Object result = null;
		
		try {
			// Before Execution
			System.out.println("Before Execution");
			
			result = proceedJoinPoint.proceed();
			
			// After Execution
			System.out.println("After Execution");
			
			return result;
			
		} catch (Throwable e) {
			// After Throwing
			System.out.println("After Throwing");
			
			throw new RuntimeException(e);
		} finally {
			// After Finally
			System.out.println("After Finally");
		}

	}

}
