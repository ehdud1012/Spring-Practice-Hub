package com.kdy.pooh.photogallery;

import java.math.BigDecimal;
import java.util.Date;

public class PhotoGallery {
	private BigDecimal pg_no;
	private String pg_writer;
	private String pg_title;
	private String pg_file;
	private Date pg_date;
	
	public PhotoGallery() {
		// TODO Auto-generated constructor stub
	}
	
	public PhotoGallery(BigDecimal pg_no, String pg_writer, String pg_title, String pg_file, Date pg_date) {
		super();
		this.pg_no = pg_no;
		this.pg_writer = pg_writer;
		this.pg_title = pg_title;
		this.pg_file = pg_file;
		this.pg_date = pg_date;
	}
	public BigDecimal getPg_no() {
		return pg_no;
	}
	public void setPg_no(BigDecimal pg_no) {
		this.pg_no = pg_no;
	}
	public String getPg_writer() {
		return pg_writer;
	}
	public void setPg_writer(String pg_writer) {
		this.pg_writer = pg_writer;
	}
	public String getPg_title() {
		return pg_title;
	}
	public void setPg_title(String pg_title) {
		this.pg_title = pg_title;
	}
	public String getPg_file() {
		return pg_file;
	}
	public void setPg_file(String pg_file) {
		this.pg_file = pg_file;
	}
	public Date getPg_date() {
		return pg_date;
	}
	public void setPg_date(Date pg_date) {
		this.pg_date = pg_date;
	}
	
}
