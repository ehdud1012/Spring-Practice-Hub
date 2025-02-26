package com.kdy.oct021mb.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.oct021mb.img.ImgDAO;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		super();
		try {
			KdyDBManager.getKdbm().newSSF("com/kdy/oct021mb/main/config.xml");
			ImgDAO.getIdao().setAllImgCount();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImgDAO.getIdao().get(request,1);
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
