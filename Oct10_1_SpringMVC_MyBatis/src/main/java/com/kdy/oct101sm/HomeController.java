package com.kdy.oct101sm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdy.oct101sm.menu.Menu;
import com.kdy.oct101sm.menu.MenuDAO;

@Controller
public class HomeController {

	@Autowired
	private MenuDAO mDAO;
	
	@Autowired
	private KdyTokenGenerator tg;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		mDAO.select(req);
		return "index";
	}

}
