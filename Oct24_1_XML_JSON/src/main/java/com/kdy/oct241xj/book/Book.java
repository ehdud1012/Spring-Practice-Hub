package com.kdy.oct241xj.book;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private String b_title;
	private BigDecimal b_price;
	// MyBatis 최신 버전은  int 사용됨
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String b_title, BigDecimal b_price) {
		super();
		this.b_title = b_title;
		this.b_price = b_price;
	}

	public String getB_title() {
		return b_title;
	}

	@XmlElement
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public BigDecimal getB_price() {
		return b_price;
	}

	@XmlElement
	public void setB_price(BigDecimal b_price) {
		this.b_price = b_price;
	}
}
