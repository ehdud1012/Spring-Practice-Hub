package com.kdy.sep302mb.product;

import java.math.BigDecimal;

public class Product2 {
	private BigDecimal p_price1;
	private BigDecimal p_price2;
	
	public Product2() {
		// TODO Auto-generated constructor stub
	}

	public Product2(BigDecimal p_price1, BigDecimal p_price2) {
		super();
		this.p_price1 = p_price1;
		this.p_price2 = p_price2;
	}

	public BigDecimal getP_price1() {
		return p_price1;
	}

	public void setP_price1(BigDecimal p_price1) {
		this.p_price1 = p_price1;
	}

	public BigDecimal getP_price2() {
		return p_price2;
	}

	public void setP_price2(BigDecimal p_price2) {
		this.p_price2 = p_price2;
	}
	
	
	
	
}
