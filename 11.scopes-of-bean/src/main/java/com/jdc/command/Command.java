package com.jdc.command;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Command {
	
	public Command() {
		System.out.println("Command was created.");
	}
	
	public void action() {
		System.out.println("Command is done!");
	}

}
