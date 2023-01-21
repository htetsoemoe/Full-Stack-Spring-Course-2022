package com.jdc.command.xml;

public abstract class CommandManager {
	public CommandManager() {
		System.out.println("CommandManager was created.");
	}
	
	public void execute() {
		getCommand().action();
	}
	
	protected abstract Command getCommand(); // look-up method
}
