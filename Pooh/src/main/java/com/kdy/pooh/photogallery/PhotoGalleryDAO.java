package com.kdy.pooh.photogallery;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdy.pooh.POOH_Option;
import com.kdy.pooh.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class PhotoGalleryDAO {
	@Autowired
	private SqlSession ss;
	@Autowired
	private POOH_Option poohOption;
	
	private int allGalleryPostCount;
	private int GalleryPostPerPage;
	
	
	public void upload(HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/pooh_PhotoGallery");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());	
		} catch (Exception e) {
			req.setAttribute("result", "업로드 실패 (파일용량)");
			return;
		}
		try {
			String token = mr.getParameter("token");
			String oldSuccessToken = (String) (req.getSession().getAttribute("successToken"));
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginUser");
			
			String title = mr.getParameter("pg_title");
			String photo = URLEncoder.encode(mr.getFilesystemName("pg_file"), "utf-8").replace("+", " ");
			PhotoGallery pg = new PhotoGallery(null, m.getPm_id(), title, photo, null);
			
			if (ss.getMapper(PhotoGalleryMapper.class).photoUpload(pg) == 1) {
				req.setAttribute("result", "업로드 성공");
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "업로드 실패");
				new File(path + "/" + mr.getFilesystemName("pg_file")).delete();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void galleryGet(HttpServletRequest req, int g_page) {
		try {
			int postCount = allGalleryPostCount;
			GalleryPostPerPage = poohOption.getGalleryPostPerPage();
			String searchWord = (String) req.getSession().getAttribute("g_search");
			GalleryPostSelector gps = new GalleryPostSelector(null, searchWord);
			if (searchWord == null) {
				gps.setG_search("");
			} else {
				postCount = ss.getMapper(PhotoGalleryMapper.class).galleryPostCount(gps);
			}
			int g_pageCount = (int) Math.ceil(postCount / (double) GalleryPostPerPage);
			req.setAttribute("g_pageCount", g_pageCount);
			req.setAttribute("g_page", g_page);
			BigDecimal end = new BigDecimal(g_page * GalleryPostPerPage);
			gps.setG_end(end);
			List<PhotoGallery> pg = ss.getMapper(PhotoGalleryMapper.class).galleryGet(gps);
			req.setAttribute("GalleryPost", pg);
		} catch (Exception e) {
			
		}
	}
	public void search(HttpServletRequest req) {
		try {
			String search = req.getParameter("g_search");
			req.getSession().setAttribute("g_search", search);
		} catch (Exception e) {
			
		}
	}
	public void galleryDelete(PhotoGallery pg, HttpServletRequest req) {
		try {
			BigDecimal no = new BigDecimal(req.getParameter("pg_no"));
			pg.setPg_no(no);
			if (ss.getMapper(PhotoGalleryMapper.class).photoDelete(pg)== 1) {
				req.setAttribute("result", "삭제 성공");
				allGalleryPostCount --;
			} else {
				req.setAttribute("result", "삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("zz");
		}
	}
	public void g_clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("g_search", null);
	}
	public void setAllGalleryPostCount() {
		GalleryPostSelector gps = new GalleryPostSelector(null, "");
		allGalleryPostCount = ss.getMapper(PhotoGalleryMapper.class).galleryPostCount(gps);
	}
}
