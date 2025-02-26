package com.kdy.pooh.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kdy.pooh.KdyTokenGenerator;
import com.kdy.pooh.member.memberDAO;

@Controller
public class SnsController {
	
	@Autowired
	private memberDAO mDAO;
	@Autowired
	private SnsDAO sDAO;
	@Autowired
	private KdyTokenGenerator tg;
	
	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String snsGo(Sns s, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			tg.generate(req);
			sDAO.clearSearch(req);
			sDAO.get(req, 1);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/sns.post.write", method = RequestMethod.GET)
	public String writedo(Sns s, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.write(s, req);
			sDAO.clearSearch(req);
			sDAO.get(req, 1);
			tg.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/sns.postPage.go", method = RequestMethod.GET)
	public String postPageGo(HttpServletRequest req, @RequestParam(value="page") int page) {
		if (mDAO.isLogined(req)) {
			sDAO.get(req, page);
			tg.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/sns.searchPost.go", method = RequestMethod.GET)
	public String searchPostGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.search(req);
			sDAO.get(req, 1);
			tg.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/sns.post.delete", method = RequestMethod.GET)
	public String snsPostDelete(Sns s, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.delete(s, req);
			tg.generate(req);
			sDAO.clearSearch(req);
			sDAO.get(req, 1);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/sns.post.reply.delete", method = RequestMethod.GET)
	public String snsPostReplyDelete(SnsReply sr, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.replyDelete(sr, req);
			tg.generate(req);
			sDAO.clearSearch(req);
			sDAO.get(req, 1);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/sns.post.update", method = RequestMethod.GET)
	public String snsPostUpdate(Sns s, HttpServletRequest req, @RequestParam(value="page") int page) {
		if (mDAO.isLogined(req)) {
			sDAO.update(s, req);
			tg.generate(req);
			sDAO.clearSearch(req);
			sDAO.get(req, page);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/sns.post.reply.update", method = RequestMethod.GET)
	public String snsPostReplyUpdate(SnsReply sr,HttpServletRequest req, @RequestParam(value="page") int page) {
		if (mDAO.isLogined(req)) {
			sDAO.replyUpdate(sr, req);
			tg.generate(req);
			sDAO.clearSearch(req);
			sDAO.get(req, page);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.GET)
	public String replyWrite(SnsReply sr, Sns s, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.reply_Write(sr, req);
			sDAO.clearSearch(req);
			sDAO.get(req, 1);
			tg.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
