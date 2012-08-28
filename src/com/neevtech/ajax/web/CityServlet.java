package com.neevtech.ajax.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CityServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		      throws java.io.IOException {
	    doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException{
		
		System.out.println("Hello............!");
		
		String state = req.getParameter("stateValue");
		String json = "[";
		
		if(state.equals("Karnataka")){
			
			List<String> kCity = new ArrayList<String>();
			kCity.add("Bangalore");
			kCity.add("Mysore");
			
			for(String items : kCity){
				json += "\""+ items+"\",";
			}
			
		}else if(state.equals("Rajasthan")){
			
			List<String> rCity = new ArrayList<String>();
			rCity.add("Bhilwara");
			rCity.add("Jaipur");
			rCity.add("Jodhpur");
			rCity.add("Udaipur");
			
			for(String items : rCity){
				json += "\""+ items+"\",";
			}
			
		}else if(state.equals("UttarPradesh")){
			
			List<String> uCity = new ArrayList<String>();
			uCity.add("Lucknow");
			uCity.add("Kanpur");
			uCity.add("Allahabad");
			uCity.add("Varansi");
			
			for(String items : uCity){
				json += "\""+ items+"\",";
			}
		}
		
		json += "]";
		
		res.setContentType("application/json"); // Inform client that you're returning JSON.
	    res.setCharacterEncoding("UTF-8"); // Important if you want world domination.
	    res.getWriter().write(json);
	}
}
