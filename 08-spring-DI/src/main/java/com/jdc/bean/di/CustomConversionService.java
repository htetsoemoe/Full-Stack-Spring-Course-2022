package com.jdc.bean.di;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

public class CustomConversionService extends DefaultConversionService{
	
	public CustomConversionService(final String datePattern) {
		final SimpleDateFormat df = new SimpleDateFormat(datePattern);
		
		addConverter(new Converter<String, LocalDate>() {

			@Override
			public LocalDate convert(String source) {
				return LocalDate.parse(source, DateTimeFormatter.ofPattern(datePattern));
			}
		});
		
		addConverter(new Converter<String, Date>() {

			@Override
			public Date convert(String source) {
				try {
					return df.parse(source);
				} catch (ParseException e) {
					throw new IllegalArgumentException("%s cannot convert".formatted(source));
				}
			}
		});
	}

}
