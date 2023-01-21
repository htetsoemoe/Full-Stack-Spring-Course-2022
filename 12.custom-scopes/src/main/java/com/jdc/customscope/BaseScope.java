package com.jdc.customscope;

import org.springframework.beans.factory.config.Scope;

public interface BaseScope extends Scope{
	@Override
	default String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	default void registerDestructionCallback(String name, Runnable callback) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	default Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
