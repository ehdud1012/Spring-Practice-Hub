package com.kdy.oct241xj.book;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Books {
	private List<Book> book;
	
	public Books() {
		// TODO Auto-generated constructor stub
	}
	
	public Books(List<Book> book) {
		super();
		this.book = book;
	}

	public List<Book> getBook() {
		return book;
	}

	@XmlElement
	public void setBook(List<Book> book) {
		this.book = book;
	}
	
}
