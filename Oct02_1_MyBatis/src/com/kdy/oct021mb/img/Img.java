package com.kdy.oct021mb.img;

import java.math.BigDecimal;
import java.util.Date;

public class Img {
	private BigDecimal o_no;
	private String o_title;
	private String o_file;
	private Date o_date;
	
	public Img() {
		// TODO Auto-generated constructor stub
	}

	public Img(BigDecimal o_no, String o_title, String o_file, Date o_date) {
		super();
		this.o_no = o_no;
		this.o_title = o_title;
		this.o_file = o_file;
		this.o_date = o_date;
	}

	public BigDecimal getO_no() {
		return o_no;
	}

	public void setO_no(BigDecimal o_no) {
		this.o_no = o_no;
	}

	public String getO_title() {
		return o_title;
	}

	public void setO_title(String o_title) {
		this.o_title = o_title;
	}

	public String getO_file() {
		return o_file;
	}

	public void setO_file(String o_file) {
		this.o_file = o_file;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}
	
}
