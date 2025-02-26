package com.kdy.oct072smvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP MOdel 2
// 	주소:포트/프로젝트명/컨트롤러명
// 	C에서 실행
//	C - Servlet
//		do-Get, do-Post -> C가 많아짐
//	어쨌든 C는 forward 하면서 끝 - 길어
//	마지막에 index.html 만들어서 마무리

// Spring MVC
// 	주소:포트/패키지마지막자리/마음대로
// 	프로젝트에서 실행
// 	C - 일반 클래스 : 대신 @Controller 붙은
//	 	일반 메소드 : @RequestMapping(value="주소(마음대로)에 들어갈 이름", method=RequestMethod.GET/POST)
//	forward 간소화
//	value="/"으로 쓰기 (비우기)
@Controller
public class HomeController {
	
	// abcd라는 주소로 GET방식 요청 들어오면 test(); 호출
	@RequestMapping(value="/test.do", method=RequestMethod.GET)
	public String test() {
		System.out.println("test");
		return "aaa"; // aaa.jsp로 
	}
	@RequestMapping(value="/test2.do", method=RequestMethod.GET)
	public String test2() {
		System.out.println("test2");
		return "bbb"; 
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		System.out.println("home");
		return "input"; 
	}
	
	// req.param값 받기
	//	1) JSP st. : 형변환 수동
	//		@RequestMapping(value="/xy.calculate", method=RequestMethod.GET)
	//		public String calc(HttpServletRequest req) {
	//			int x = Integer.parseInt(req.getParameter("x"));
	//			int y = Integer.parseInt(req.getParameter("y"));
	//			System.out.println(x + ", " + y);
	//			return "input"; 
	//		}
	
	//	2) Spring st. : 형변환 알아서
	//		@RequestMapping(value="/xy.calculate", method=RequestMethod.GET)
	//		public String calc(@RequestParam(value="x") int x, @RequestParam(value="y") int y) {
	//			System.out.println(x + ", " + y);
	//			return "input"; 
	//		}
	
	@Autowired
	private Calculator c;
	
	//	3) Spring st.
	//		Spring이 req param 받아서 JavaBean객체로 만들어줌
	//		멤버변수명  = req param
	//		파일업로드. 날짜는 불가 -> 1번 사용
	@RequestMapping(value="/xy.calculate", method=RequestMethod.GET)
	public String calc(XYxy xy, HttpServletRequest req) {
		c.claculate(xy, req);
		return "output"; 
	}
}
