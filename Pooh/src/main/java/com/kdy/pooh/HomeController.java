package com.kdy.pooh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdy.pooh.member.memberDAO;
import com.kdy.pooh.photogallery.PhotoGalleryDAO;
import com.kdy.pooh.sns.SnsDAO;


@Controller
public class HomeController {

	@Autowired
	private memberDAO mDAO;
	@Autowired
	private SnsDAO sDAO;
	@Autowired
	private PhotoGalleryDAO pgDAO;
	
// ~ JSP 
//		수작업 singleton
//		객체 하나 만들어서 static 영역
//		-실행-> DAO -> 톰캣 돌며 시작 -> HomeController
	
// Spring 
//		xml에 하나 등록해놓고 Autowired로 갖다쓰는
//		Spring이 객체 하나 자동으로 만들었을 뿐
//	이게 왜 안되는 것인가?
//	public HomeController() {
//		sDAO.setAllPostCount(); ==> c가 먼저 생겨서 이때는 sDAO가 없는 상태
//	}
//		==> 서비스 시작하고 최초의 요청 때 진행
	
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if(firstReq) {
			sDAO.setAllPostCount();
			pgDAO.setAllGalleryPostCount();
			firstReq = false;
		}
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req) {
		return home(req);
	}
	
}
