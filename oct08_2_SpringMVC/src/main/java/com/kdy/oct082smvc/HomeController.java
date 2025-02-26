package com.kdy.oct082smvc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {

	@Autowired
	private UnitConverter uc;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		try {
			// String으로 된 계산 : JAva에는 없고 JS에는 있음
			String s = "1+1";
			// Java에서 JS를 갖다쓰기 가능
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine se = sem.getEngineByName("JavaScript");
			System.out.println(se.eval(s));
			
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return "input";
	}
	@RequestMapping(value = "/Calculate.do", method = RequestMethod.GET)
	public String unitChange(Unit u, HttpServletRequest request) {
		uc.convert(u, request);
		return "output";
	}
	
}
