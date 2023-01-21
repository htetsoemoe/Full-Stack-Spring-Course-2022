package com.ninja.bean.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.PriorityOrdered;

public class MyFirstFactoryPostProcessor implements BeanFactoryPostProcessor, PriorityOrdered{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("My Fisrt FactoryPostProcessor...");
		
		var customMessage = new GenericBeanDefinition();
		customMessage.setBeanClass(RuntimeMessage.class);
		customMessage.getPropertyValues().add("value", "Custom Message Bean at Runtime");
		
		if (beanFactory instanceof DefaultListableBeanFactory bf) {
			bf.registerBeanDefinition("customMessage", customMessage);
		}
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
