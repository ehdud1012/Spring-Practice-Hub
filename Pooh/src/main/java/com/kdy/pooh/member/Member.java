package com.kdy.pooh.member;

import java.util.Date;

public class Member {
	private String pm_id;
	private String pm_pw;
	private String pm_name;
	private String pm_photo;
	private Date pm_birthday;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String pm_id, String pm_pw, String pm_name, String pm_photo, Date pm_birthday) {
		super();
		this.pm_id = pm_id;
		this.pm_pw = pm_pw;
		this.pm_name = pm_name;
		this.pm_photo = pm_photo;
		this.pm_birthday = pm_birthday;
	}
	
	public String getPm_id() {
		return pm_id;
	}

	public void setPm_id(String pm_id) {
		this.pm_id = pm_id;
	}

	public String getPm_pw() {
		return pm_pw;
	}

	public void setPm_pw(String pm_pw) {
		this.pm_pw = pm_pw;
	}

	public String getPm_name() {
		return pm_name;
	}

	public void setPm_name(String pm_name) {
		this.pm_name = pm_name;
	}

	public String getPm_photo() {
		return pm_photo;
	}

	public void setPm_photo(String pm_photo) {
		this.pm_photo = pm_photo;
	}

	public Date getPm_birthday() {
		return pm_birthday;
	}

	public void setPm_birthday(Date pm_birthday) {
		this.pm_birthday = pm_birthday;
	}

}
