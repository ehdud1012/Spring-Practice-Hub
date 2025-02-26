package com.kdy.oct021mb.img;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class allery
 */
@WebServlet("/ImgController")
public class ImgController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImgDAO.getIdao().upload(request);
		ImgDAO.getIdao().get(request,1);
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
