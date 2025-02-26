package com.kdy.oct241xj.snack;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void get(HttpServletRequest req) {
		try {
			req.setAttribute("snack", ss.getMapper(SnackMapper.class).getSnack()); 
		} catch (Exception e) {
		}
	}
	
	public Snacks toXML() {
		List<Snack> snacks = ss.getMapper(SnackMapper.class).getSnack();
		Snacks snacks2 = new Snacks(snacks);
		return snacks2;
	}
}
