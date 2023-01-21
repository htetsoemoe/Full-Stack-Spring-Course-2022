package com.jdc.stream.service;

import java.io.IOException;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Service
public class DataProvider {
	
	private final List<String> data;
	
	public DataProvider() {
		data = List.of(
				"Java",
				"Spring Framework",
				"Spring Cloud",
				"JavaFX",
				"MySQL",
				"Web Design",
				"JavaScript",
				"TypeScript",
				"Angular",
				"NodeJS",
				"Git",
				"Docker"
				);
	}
	
	@Async
	public void stream(ResponseBodyEmitter emitter) {
		StreamState state = new StreamState();
		
		emitter.onTimeout(() -> {
			System.out.println("Override Timeout Handler");
			synchronized (state) {
				state.setComplete();
			}
		});
		
		try {
			for(var item : this.data) {
				Thread.sleep(1000L);
				synchronized (this) {
					if (state.isComplete()) {
						break;
					}
				}
				emitter.send(item);
			}
		} catch (InterruptedException | IOException e) {
			throw new RuntimeException("Connection Lost.");
		} finally {
			emitter.complete();
		}
	}

}
