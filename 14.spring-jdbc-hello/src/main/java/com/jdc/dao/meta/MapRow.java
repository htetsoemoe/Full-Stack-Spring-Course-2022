package com.jdc.dao.meta;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Component
@Retention(RUNTIME)
@Target({ TYPE, PARAMETER })
public @interface MapRow {

}
