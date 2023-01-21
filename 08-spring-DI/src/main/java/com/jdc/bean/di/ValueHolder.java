package com.jdc.bean.di;

import java.time.LocalDate;
import java.util.Date;

public class ValueHolder {
	private LocalDate localDate;
	private Date utilDate;

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(Date utilDate) {
		this.utilDate = utilDate;
	}

}
