package com.kdy.oct241xj.snack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SnackController {
	@Autowired
	private SnackDAO sDAO;

	// 응답을 하려면  @ResponseBody => "index" 라는 글자 응답
	@RequestMapping(value = "/snack.test", method = RequestMethod.GET)
	public @ResponseBody String snackTest(HttpServletRequest req) {
		return "index";
	}
	
	// 요청 -> XML
	// XML
	//		정확하게 XML이 뜨게 하려면  ▽ 추가 
	//			produces = "application/xml;charset=utf-8"
	@RequestMapping(value = "/snack.get", method = RequestMethod.GET, produces = "application/xml;charset=utf-8")
	public @ResponseBody Snacks snackGet(HttpServletResponse res) {
		// XML 자료를 외부에서도 사용 가능하게 하려면 (cross-domain AJAX 가능하게)
		// res.setHeader("Access-Control-Allow-Origin", "사용가능하게 할 컴퓨터 IP 주소"); 
		res.setHeader("Access-Control-Allow-Origin", "*");  // 모두 허용
		
		Snacks snacks = sDAO.toXML();
		return snacks;
	}
	
	
}
