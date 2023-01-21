package com.jdc.bean.di;

import java.time.LocalDate;
import java.util.Map;

public class MapHolder {
	
	private Map<String, LocalDate> dates;

	public Map<String, LocalDate> getDates() {
		return dates;
	}

	public void setDates(Map<String, LocalDate> dates) {
		this.dates = dates;
	}
	
	
}
