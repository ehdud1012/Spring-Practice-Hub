package com.kdy.pooh.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kdy.pooh.photogallery.PhotoGalleryDAO;
import com.kdy.pooh.sns.SnsDAO;


@Controller
public class MemberController {
	
	@Autowired
	private memberDAO mDAO;
	@Autowired
	private SnsDAO sDAO;
	@Autowired
	private PhotoGalleryDAO pgDAO;
	
	@RequestMapping(value = "/member.bye.go", method = RequestMethod.GET)
	public String byeGo(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.memberDelete(req);
			mDAO.logout(req);
			sDAO.setAllPostCount();
			pgDAO.setAllGalleryPostCount();
		}
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String infoGo(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			req.setAttribute("contentPage", "member/info.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/member.info.update.go", method = RequestMethod.POST)
	public String infoUpdateGo(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.infoUpdate(m, req);
		}
		req.setAttribute("contentPage", "member/info.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String joinDo(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/join.go", method = RequestMethod.GET)
	public String joinGo(HttpServletRequest req) {
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginDo(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/logout.go", method = RequestMethod.GET)
	public String logoutGo(HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	
	
	
}
