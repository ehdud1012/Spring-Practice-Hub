package com.kdy.oct101sm.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdy.oct101sm.KdyTokenGenerator;

@Controller
public class MenuController {
	
	@Autowired
	private MenuDAO mDAO;
	
	@Autowired
	private KdyTokenGenerator tg;
	
	@RequestMapping(value = "/menu.reg", method = RequestMethod.GET)
	public String reg(Menu m, HttpServletRequest req) {
		mDAO.reg(m, req);
		mDAO.select(req);
		tg.generate(req);
		return "index";
	}
}
