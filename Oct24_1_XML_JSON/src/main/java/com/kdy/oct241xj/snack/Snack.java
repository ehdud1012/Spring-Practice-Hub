package com.kdy.oct241xj.snack;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// JavaBean / DTO / VO
//		DB에 있는 데이터 하나를 표현가능
//		+ DB에 있는 테이블를 표현가능

@XmlRootElement
public class Snack {
	private String s_name;
	private BigDecimal s_price;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public String getS_name() {
		return s_name;
	}

	@XmlElement
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public BigDecimal getS_price() {
		return s_price;
	}

	@XmlElement
	public void setS_price(BigDecimal s_price) {
		this.s_price = s_price;
	}

	public Snack(String s_name, BigDecimal s_price) {
		super();
		this.s_name = s_name;
		this.s_price = s_price;
	}
}
