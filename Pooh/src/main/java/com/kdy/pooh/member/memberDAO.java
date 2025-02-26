package com.kdy.pooh.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class memberDAO {
	
	@Autowired
	private SqlSession ss;
	
	private SimpleDateFormat sdf ;
	public memberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}
	
	public void infoUpdate(Member m , HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/pooh_Photo");
		MultipartRequest mr = null;

		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());	
		
		} catch (Exception e) {
			req.setAttribute("result", "수정실패 (파일용량)");
			return;
		}
		
		String newphoto = null;
		String oldphoto = null;
		try {
			Member loginUser = (Member) req.getSession().getAttribute("loginUser");
			String pw = mr.getParameter("pm_pw");
			String name = mr.getParameter("pm_name");
			
			oldphoto = loginUser.getPm_photo();
			newphoto = mr.getFilesystemName("pm_photo");
			if (newphoto != null) {
				newphoto = URLEncoder.encode(newphoto, "utf-8").replace("+", " ");
			} else {
				newphoto = oldphoto;
			}
			m.setPm_id(loginUser.getPm_id());			m.setPm_pw(pw);		m.setPm_name(name);
			m.setPm_photo(newphoto); 	m.setPm_birthday(loginUser.getPm_birthday());
			
			if(ss.getMapper(MemberMapper.class).update(m) == 1) {
				req.setAttribute("result", "업데이트성공");
				req.getSession().setAttribute("loginUser", m);
				if (!newphoto.equals(oldphoto)) {
					File f = new File(path + "/" + URLDecoder.decode(oldphoto, "utf-8"));
					f.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "업데이트실패");
			if (!newphoto.equals(oldphoto)) {
				File f = new File(path + "/" + newphoto);
				f.delete();
			}
		}
	}
	
	
	public boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginUser");
		if (m != null) { // 로그인 됨
			req.setAttribute("loginPage", "member/logined.jsp");
			return true;
		}
		req.setAttribute("loginPage", "member/login.jsp");
		return false; // 안됨
		
	}
	
	public void join(Member m , HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/pooh_Photo");
		MultipartRequest mr = null;

		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());	
		
		} catch (Exception e) {
			req.setAttribute("result", "가입실패(프사)");
		}
		
		try {
			String id = mr.getParameter("pm_id");
			String pw = mr.getParameter("pm_pw");
			String name = mr.getParameter("pm_name");
			
			String j1 = mr.getParameter("pm_jumin1");
			String j2 = mr.getParameter("pm_jumin2");
			
			if (j2.equals("1") || j2.equals("2")) {
				j1 = 19+j1;
			}
			else if (j2.equals("3") || j2.equals("4")) {
				j1 = 20+j1;
			}
			Date bd = sdf.parse(j1);
			
			String photo = URLEncoder.encode(mr.getFilesystemName("pm_photo"), "utf-8").replace("+", " ");
			
			m.setPm_id(id);			m.setPm_pw(pw);		m.setPm_name(name);
			m.setPm_photo(photo); 	m.setPm_birthday(bd);
			
			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("result", "가입성공");
			} else {
				req.setAttribute("result", "가입실패");
				new File(path + "/" + mr.getFilesystemName("pm_photo")).delete();
			}
			
		} catch (Exception e) {
		}
	}
	public void login(Member m, HttpServletRequest req) {
		try {
			Member loginUser = ss.getMapper(MemberMapper.class).getMemberByID(m);
			
			if (loginUser != null) {
				if (loginUser.getPm_id().equals(m.getPm_id())) {
					req.setAttribute("result", "로그인성공");
					req.getSession().setAttribute("loginUser", loginUser);
					req.getSession().setMaxInactiveInterval(6000);
				} else {
					req.setAttribute("result", "로그인실패(PW)");
				}
			} else {
				req.setAttribute("result", "로그인실패(미가입ID)");
			}
			
		} catch (Exception e) {
			req.setAttribute("result", "로그인실패(DB)");
		}
	}
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginUser", null);
	}
	
	public void memberDelete(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginUser");
			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("result", "탈퇴성공");
				String path = req.getSession().getServletContext().getRealPath("resources/pooh_Photo");
				File f = new File(path + "/" + URLDecoder.decode(m.getPm_photo(), "utf-8"));
				f.delete();
				
				// 어차피 탈되했을때 멤버 포스트 세는 것도 DB랑 서버랑 연결하는거니까 
				//	=> 걍 전체 포스트 개수 세는게 효튤적임
				
			}
		} catch (Exception e) {
			req.setAttribute("result", "탈퇴실패");
		}
	}
	
}
