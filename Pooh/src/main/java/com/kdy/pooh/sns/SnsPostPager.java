package com.kdy.pooh.sns;

import java.math.BigDecimal;

public class SnsPostPager {
	private BigDecimal start;
	private BigDecimal end;
	private String search;
	
	public SnsPostPager() {
		// TODO Auto-generated constructor stub
	}
	
	public SnsPostPager(BigDecimal start, BigDecimal end, String search) {
		super();
		this.start = start;
		this.end = end;
		this.search = search;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
}
