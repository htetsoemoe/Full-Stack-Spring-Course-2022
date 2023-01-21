package com.jdc.stream.service;

public class StreamState {
	private volatile boolean timeout;
	
	public synchronized void setComplete() {
		timeout = true;
	}
	
	public synchronized boolean isComplete() {
		return timeout;
	}
}
