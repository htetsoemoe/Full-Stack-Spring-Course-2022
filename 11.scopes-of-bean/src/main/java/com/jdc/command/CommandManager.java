package com.jdc.command;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CommandManager {

	@Autowired
	private BeanFactory beanFactory;
	
	public CommandManager() {
		System.out.println("CommandManager was Created.");
	}
	
	public void execute() {
		beanFactory.getBean(Command.class).action();
	}
}
