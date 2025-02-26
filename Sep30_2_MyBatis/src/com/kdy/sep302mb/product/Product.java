package com.kdy.sep302mb.product;

import java.math.BigDecimal;

// library : 규칙대로 하면 자동으로 
// Framework : library + 자체 툴

// MyBatis
//		- 유지보수 Framework
//		- DB ORM Framework
//			DB의 데이터를 자동으로 자바객체로 만들어주는
// 	- DB 필드명 = 멤버변수명 (자동 맵핑)
//  - (Oracke DB 한정) 
//		number 가 정수/실수   다 소화해서
//		Java에서도 정수/실수 다 소화하는 자료형 필요
//			그 자료형 = BigDecimal

// w\자료형
// varchar2, char -> String
// date -> java.util.date


public class Product {
	 private String p_name;
	 private BigDecimal p_price;
	 
	 public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String p_name, BigDecimal p_price) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}
}
