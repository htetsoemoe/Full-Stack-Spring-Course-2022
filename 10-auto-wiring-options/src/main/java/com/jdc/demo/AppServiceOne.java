package com.jdc.demo;

import org.springframework.stereotype.Component;

import com.jdc.config.qualifiers.ServiceOne;

@Component
@ServiceOne
public class AppServiceOne implements AppService{

}
