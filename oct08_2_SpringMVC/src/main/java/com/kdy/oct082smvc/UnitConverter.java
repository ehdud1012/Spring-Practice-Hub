package com.kdy.oct082smvc;

import java.util.ArrayList;
import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;


public class UnitConverter {
	private HashMap<String, ArrayList<String>> units;
	private ScriptEngine se;
	
	private UnitConverter() {

	}
	
	public UnitConverter(HashMap<String, ArrayList<String>> units) {
		super();
		this.units = units;
		ScriptEngineManager sem = new ScriptEngineManager();
		se = sem.getEngineByName("JavaScript");
	}
	
	public void convert(Unit u, HttpServletRequest request) {
		try {
			String unit = u.getUnit();
			String num = u.getInput();
			
			String result = units.get(unit).get(2);
			result = result.replace("n", num);
			
			double result2 = (Double) se.eval(result);
			
			UCResult ucr = 
					new UCResult(num, units.get(unit).get(0), result2, units.get(unit).get(1), unit);
			
			request.setAttribute("result", ucr);
			
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
	}
}
