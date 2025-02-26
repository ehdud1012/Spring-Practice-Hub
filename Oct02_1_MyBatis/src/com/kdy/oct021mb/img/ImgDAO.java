package com.kdy.oct021mb.img;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.kdy.db.manager.KdyDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ImgDAO {
	private static final ImgDAO IDAO = new ImgDAO();
	
	private int allImgCount;
	private int imgPerPage;
	
	private ImgDAO() {
		imgPerPage = 3;
	}
	public static ImgDAO getIdao() {
		return IDAO;
	}
	
	
	public void upload(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			String path = req.getSession().getServletContext().getRealPath("img");
			MultipartRequest  mr = new MultipartRequest( req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
			String title = mr.getParameter("title");
			String img = URLEncoder.encode(mr.getFilesystemName("img"), "utf-8").replace("+", " ");
			
			Img i = new Img(null, title, img, null);
			if (ss.insert("imgMapper.upload", i) == 1) {
				req.setAttribute("result", "등록성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
		ss.close();
	}
	public void get(HttpServletRequest req, int page) {
		SqlSession ss = null;
		try {
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			
			int pageCount = (int) Math.ceil(allImgCount / (double) imgPerPage);
			req.setAttribute("pageCount", pageCount);
			
			BigDecimal start = new BigDecimal((page - 1) * imgPerPage + 1);
			BigDecimal end = new BigDecimal(page * imgPerPage);
			ImgPager i = new ImgPager(start, end);
			
			List<Img> imgs = ss.selectList("imgMapper.imgSelect", i);
			req.setAttribute("img", imgs);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		}
		ss.close();
//		이렇게까지 줄일 수 있음 근데 안함
//		SqlSession ss = KdyDBManager.getKdbm().getSsf().openSession();
//		req.setAttribute("img", ss.selectList("imgMapper.imgSelect"));
//		ss.close();
	}
	public void setAllImgCount() {
		SqlSession ss = null;
		try {
			ss = KdyDBManager.getKdbm().getSsf().openSession();
			allImgCount = ss.selectOne("imgMapper.imgCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
