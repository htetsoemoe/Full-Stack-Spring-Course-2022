package com.jdc.demo;

import org.springframework.stereotype.Component;

import com.jdc.config.qualifiers.ServiceTwo;

@Component
@ServiceTwo
public class AppServiceTwo implements AppService{

}
