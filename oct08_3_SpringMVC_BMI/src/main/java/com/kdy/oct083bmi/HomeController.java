package com.kdy.oct083bmi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdy.oct083bmi.bmi.Calculator;
import com.kdy.oct083bmi.bmi.UserInfo;

@Controller
public class HomeController {

	@Autowired
	private Calculator c;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "input";
	}
	@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
	public String calculate(UserInfo ui, HttpServletRequest req) {
		c.calculate(ui, req);
		return "output";
	}
	
}
