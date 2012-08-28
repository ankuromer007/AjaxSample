package com.neevtech.ajax.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowList extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException{
		
		List<String> itemList = new ArrayList<String>();
		
		itemList.add("Movies");
		itemList.add("Songs");
		itemList.add("Computers");
		itemList.add("Mobiles");
		itemList.add("Laptops");
		
		String json = "[";
		for(String items : itemList){
			json += "\""+ items+"\",";
		}
		json += "]";
		
		res.setContentType("application/json"); // Inform client that you're returning JSON.
	    res.setCharacterEncoding("UTF-8"); // Important if you want world domination.
	    res.getWriter().write(json);
	}
}
