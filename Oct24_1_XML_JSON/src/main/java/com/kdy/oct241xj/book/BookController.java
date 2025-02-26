package com.kdy.oct241xj.book;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {
	
	@Autowired
	private BookDAO bDAO;
	
	@RequestMapping(value = "/book.get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody Books bookGet(HttpServletResponse res) {
		return bDAO.toJSON();
	}
	@RequestMapping(value = "/book.getXML", method = RequestMethod.GET, produces = "application/xml;charset=utf-8")
	public @ResponseBody Books bookGetXML(HttpServletResponse res) {
		return bDAO.toXML();
	}
	
}
