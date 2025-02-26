package com.kdy.oct071sdi.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {
	private String dateFormat;
	
	public DateManager() {
		// TODO Auto-generated constructor stub
	}
	
	public DateManager(String dateFormat) {
		super();
		this.dateFormat = dateFormat;
	}
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void printDate() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+dateFormat+"MM"+dateFormat+"dd");
		
		String curdate = sdf.format(now);
		System.out.println(curdate);
	}
}
