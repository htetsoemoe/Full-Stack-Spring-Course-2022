package com.jdc.demo;

import java.text.DecimalFormat;

public class MyFormatter {

	public static String format(int value) {
		var fmtValue = new DecimalFormat("#,##0");
		return fmtValue.format(value);
	}
}
