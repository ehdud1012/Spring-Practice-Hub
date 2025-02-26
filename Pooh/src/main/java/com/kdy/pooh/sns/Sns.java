package com.kdy.pooh.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Sns {
	private BigDecimal ps_no;
	private String ps_txt;
	private Date ps_date;
	private String ps_writer;
	
	private String pm_photo;
	
	private List<SnsReply> sr_replys;
	
	public Sns() {
		// TODO Auto-generated constructor stub
	}

	public Sns(BigDecimal ps_no, String ps_txt, Date ps_date, String ps_writer, String pm_photo,
			List<SnsReply> sr_replys) {
		super();
		this.ps_no = ps_no;
		this.ps_txt = ps_txt;
		this.ps_date = ps_date;
		this.ps_writer = ps_writer;
		this.pm_photo = pm_photo;
		this.sr_replys = sr_replys;
	}

	public BigDecimal getPs_no() {
		return ps_no;
	}

	public void setPs_no(BigDecimal ps_no) {
		this.ps_no = ps_no;
	}

	public String getPs_txt() {
		return ps_txt;
	}

	public void setPs_txt(String ps_txt) {
		this.ps_txt = ps_txt;
	}

	public Date getPs_date() {
		return ps_date;
	}

	public void setPs_date(Date ps_date) {
		this.ps_date = ps_date;
	}

	public String getPs_writer() {
		return ps_writer;
	}

	public void setPs_writer(String ps_writer) {
		this.ps_writer = ps_writer;
	}

	public String getPm_photo() {
		return pm_photo;
	}

	public void setPm_photo(String pm_photo) {
		this.pm_photo = pm_photo;
	}

	public List<SnsReply> getSr_replys() {
		return sr_replys;
	}

	public void setSr_replys(List<SnsReply> sr_replys) {
		this.sr_replys = sr_replys;
	}
}
