package com.kdy.pooh.photogallery;

import java.math.BigDecimal;

public class GalleryPostSelector {
	private BigDecimal g_end;
	private String g_search;
	
	public GalleryPostSelector() {
		// TODO Auto-generated constructor stub
	}
	
	public GalleryPostSelector(BigDecimal g_end, String g_search) {
		super();
		this.g_end = g_end;
		this.g_search = g_search;
	}
	public BigDecimal getG_end() {
		return g_end;
	}
	public void setG_end(BigDecimal g_end) {
		this.g_end = g_end;
	}
	public String getG_search() {
		return g_search;
	}
	public void setG_search(String g_search) {
		this.g_search = g_search;
	}

	
}
