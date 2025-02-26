package com.kdy.oct101sm.menu;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	
	//  servlet-cintext.xml에 SqlSessionTemplate에 등록 해 놓음
	// SqlSession : 수동 commit, 연결관리
	// SqlSessionTemplet : 자동 commit, 연결관리
	@Autowired
	private SqlSession ss;

//	public void reg(Menu m) {
//		// interface 불러오기
//		MenuMapper mm = ss.getMapper(MenuMapper.class);
//		// 추상메소드 호출 -> 연결된 mapper.xml -> sql 실행
//		mm.menuReg(m);
//		
//		// ▽ 줄여서
//		// ss.getMapper(MenuMapper.class).menuReg(m);
//	}
	
	// 실전 버전
	public void reg(Menu m, HttpServletRequest req) {
		try {
			// 새로고침
			String token = req.getParameter("token");
			String oldSuccessToken = (String) req.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				req.setAttribute("result", "등록실패(새로고침)");
				return;
			}
			
			// DB 등록
			if (ss.getMapper(MenuMapper.class).menuReg(m) == 1) {
				req.setAttribute("result", "등록성공");
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "등록실패");
			}
			
		} catch (Exception e) {
			req.setAttribute("result", "등록실패 (DB서버)");
		}
	}
	
	public void select(HttpServletRequest req) {
		req.setAttribute("menus", ss.getMapper(MenuMapper.class).menuSelect());
	
	}
}
