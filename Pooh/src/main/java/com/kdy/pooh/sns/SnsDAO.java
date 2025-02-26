package com.kdy.pooh.sns;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdy.pooh.POOH_Option;
import com.kdy.pooh.member.Member;

@Service
public class SnsDAO {
	
	@Autowired
	private SqlSession ss;
	@Autowired
	private POOH_Option poohOption;
	
	private int allPostCount;
	private  int postPerPage;

	
	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	public void delete(Sns s, HttpServletRequest req) {
		try {
			if (ss.getMapper(SnsMapper.class).snsDelete(s) == 1) {
				req.setAttribute("result", "삭제 성공");
				allPostCount --;
			}
		} catch (Exception e) {
			req.setAttribute("result", "삭제 실패");
		}
	}
	
	public void get(HttpServletRequest req, int page) {
		try {
			int postCount = allPostCount;
			postPerPage = poohOption.getSnsPostPerPage();
			String searchWord = (String) req.getSession().getAttribute("search");
			SnsPostPager spp = new SnsPostPager(null, null, searchWord);
			if (searchWord == null) {
				spp.setSearch("");
			} else {
				postCount = ss.getMapper(SnsMapper.class).getPostCount(spp);
			}
			int pageCount = (int) Math.ceil(postCount / (double) postPerPage);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);
			BigDecimal start = new BigDecimal((page - 1) * postPerPage + 1);
			BigDecimal end = new BigDecimal(page * postPerPage);
			spp.setStart(start);
			spp.setEnd(end);
			List<Sns> s = ss.getMapper(SnsMapper.class).snsGet(spp);
			for (Sns sns : s) {
				sns.setSr_replys(ss.getMapper(SnsMapper.class).snsReplyGet(sns));
			}
			
			req.setAttribute("SNSPost", s);
			
		} catch (Exception e) {
			
		}
	}
	
	public void reply_Write(SnsReply sr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String oldSuccessToken = (String) req.getSession().getAttribute("successToken");
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				req.setAttribute("result", "댓글 쓰기 실패(새로고침)");
				return;
			}
			Member m = (Member) req.getSession().getAttribute("loginUser");
			
			BigDecimal ps_no = new BigDecimal(req.getParameter("ps_no"));
			sr.setPsr_ps_no(ps_no);
			sr.setPsr_writer(m.getPm_id());
			
			if (ss.getMapper(SnsMapper.class).replyWrite(sr) == 1) {
				req.setAttribute("result", "댓글 쓰기 성공");
				req.getSession().setAttribute("successToken", token);
			}else {
				req.setAttribute("result", "댓글 쓰기 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글 쓰기 실패");
		}
	}
	public void replyDelete(SnsReply sr, HttpServletRequest req) {
		try {
			if (ss.getMapper(SnsMapper.class).replyDelete(sr) == 1) {
				req.setAttribute("result", "댓글 삭제 성공");
			}
		} catch (Exception e) {
			req.setAttribute("result", "댓글 삭제 실패");
		}
	}
	
	public void replyUpdate(SnsReply sr, HttpServletRequest req) {
		try {
			if (ss.getMapper(SnsMapper.class).replyUpdate(sr) == 1) {
				req.setAttribute("result", "댓글 업데이트 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "댓글 업데이트 실패");
		}
	}
	
	
	
	public void search(HttpServletRequest req) {
		try {
			String search = req.getParameter("search");
			req.getSession().setAttribute("search", search);
		} catch (Exception e) {
			
		}
	}
	
	
	
	public void setAllPostCount() {
		SnsPostPager spp = new SnsPostPager(null, null, "");
		allPostCount = ss.getMapper(SnsMapper.class).getPostCount(spp);
	}
	
	public void update(Sns s, HttpServletRequest req) {
		try {
			if (ss.getMapper(SnsMapper.class).postUpdate(s) == 1) {
				req.setAttribute("result", "업데이트 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "업데이트 실패");
		}
	}
	
	public void write(Sns s, HttpServletRequest req) {
		try {
			
			String token = req.getParameter("token");
			String oldSuccessToken = (String) req.getSession().getAttribute("successToken");
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				req.setAttribute("result", "등록실패(새로고침)");
				return;
			}
			Member m = (Member) req.getSession().getAttribute("loginUser");
			s.setPs_txt(s.getPs_txt().replace("\r\n", "<br>"));
			s.setPs_writer(m.getPm_id());
			
			if (ss.getMapper(SnsMapper.class).write(s) == 1) {
				req.setAttribute("result", "글쓰기 성공");
				req.getSession().setAttribute("successToken", token);
				allPostCount++;
			}else {
				req.setAttribute("result", "글쓰기 실패");
			}
			
		} catch (Exception e) {
			req.setAttribute("result", "글쓰기 실패");
		}
	}
}
