package com.kdy.oct241xj.book;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookDAO {
	
	@Autowired
	private SqlSession ss;
	
	public Books toJSON() {
		return new Books(ss.getMapper(BookMapper.class).getBook());
	}
	
	public Books toXML() {
		return new Books(ss.getMapper(BookMapper.class).getBook());
	}
}
