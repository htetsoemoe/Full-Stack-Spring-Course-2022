package com.ninja.bean.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;

public class MySecondFactoryPostProcessor implements BeanFactoryPostProcessor, PriorityOrdered{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("My Second BeanFactoryPostProcessor...");
	}

	@Override
	public int getOrder() {
		return 2;
	}
}
