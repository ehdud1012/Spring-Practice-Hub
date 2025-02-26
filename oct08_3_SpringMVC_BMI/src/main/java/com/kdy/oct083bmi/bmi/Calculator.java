package com.kdy.oct083bmi.bmi;

import java.net.URLEncoder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class Calculator {
	
	private String sik;
	private ScriptEngine se;
	
	public Calculator() {
		
	}
	
	public Calculator(String sik) {
		super();
		this.sik = sik;
		se = new ScriptEngineManager().getEngineByName("JavaScript");
	}
	
	public void calculate(UserInfo ui, HttpServletRequest req) {
		
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/oct10_photo");
			MultipartRequest mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());	
			
			String photo = URLEncoder.encode(mr.getFilesystemName("photo"), "utf-8").replace("+", " ");
			ui.setPhoto(photo);
			
			ui.setName(mr.getParameter("name"));
			ui.setHeight(Double.parseDouble(mr.getParameter("height")));
			ui.setWeight(Double.parseDouble(mr.getParameter("weight")));
			
			sik = sik.replace("h", ui.getHeight()/100 + "");
			sik = sik.replace("w", ui.getWeight() + "");
			double bmi = (Double) se.eval(sik);
			
			String result = "저체중";
			if(bmi >= 39) { result = "고도비만";}
			else if(bmi >= 32) { result = "중도비만";}
			else if(bmi >= 30) { result = "경도비만";}
			else if(bmi >= 24) { result = "과체중";}
			else if(bmi >= 10) { result = "정상";}
			ui.setBmi(bmi);
			ui.setResult(result);
			
			req.setAttribute("result", ui);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
