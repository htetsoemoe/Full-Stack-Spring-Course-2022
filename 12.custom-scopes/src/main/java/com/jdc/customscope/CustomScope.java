package com.jdc.customscope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomScope implements BaseScope {

	private Map<String, Object> instances;
	private Object lock = new Object();

	public CustomScope() {
		instances = Collections.synchronizedMap(new HashMap<>());
	}

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
//		synchronized (lock) {
//			var bean = instances.get(name);
//
//			if (null == bean) {
//				bean = objectFactory.getObject();
//				if (null != bean) {
//					instances.put(name, objectFactory);
//				}
//			}
//
//			return bean;
//		}

		synchronized (lock) {
			return Optional.ofNullable(instances.get(name))
					.orElseGet(() -> Optional.ofNullable(objectFactory.getObject())
							.stream().peek(bean -> instances.put(name, bean))
							.findAny().orElse(null));
		
		}
	}

	@Override
	public Object remove(String name) {
		synchronized (lock) {
			return instances.remove(name);
		}
	}

}
