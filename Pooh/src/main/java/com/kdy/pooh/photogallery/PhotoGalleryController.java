package com.kdy.pooh.photogallery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kdy.pooh.KdyTokenGenerator;
import com.kdy.pooh.member.memberDAO;

@Controller
public class PhotoGalleryController {
	@Autowired
	private memberDAO mDAO;
	@Autowired
	private PhotoGalleryDAO pgDAO;
	@Autowired
	private KdyTokenGenerator tg;
	
	@RequestMapping(value = "/photo.go", method = RequestMethod.GET)
	public String photoGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			tg.generate(req);
			pgDAO.g_clearSearch(req);
			pgDAO.galleryGet(req,1);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/photo.delete.do", method = RequestMethod.GET)
	public String photoDeleteDo(PhotoGallery pg, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			pgDAO.galleryDelete(pg, req);
			tg.generate(req);
			pgDAO.g_clearSearch(req);
			pgDAO.galleryGet(req, 1);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/gallery.postPage.go", method = RequestMethod.GET)
	public String galleryPostPageGo(HttpServletRequest req, @RequestParam(value="g_page") int g_page) {
		if (mDAO.isLogined(req)) {
			pgDAO.galleryGet(req, g_page);
			tg.generate(req);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/photo.upload.go", method = RequestMethod.GET)
	public String photoUploadGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			tg.generate(req);
			req.setAttribute("contentPage", "gallery/upload.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/photo.search.go", method = RequestMethod.GET)
	public String photoSearchGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			pgDAO.search(req);
			tg.generate(req);
			pgDAO.galleryGet(req,1);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/photo.upload.do", method = RequestMethod.POST)
	public String photoUploadDo(PhotoGallery pg, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			pgDAO.upload(req);
			pgDAO.g_clearSearch(req);
			pgDAO.galleryGet(req,1);
			tg.generate(req);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
