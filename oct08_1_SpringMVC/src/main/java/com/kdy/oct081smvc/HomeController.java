package com.kdy.oct081smvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "input";
	}
	
	// req param 한글처리
	// 		GET 방식 	: 톰캣 설정
	// 		POST 방식 
	//			이미 값을 받아오고 나서 처리해봤자 의미 X
	//			
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Human h) {
		System.out.println(h.getName() + h.getAge());
		return "input";
	}

}
