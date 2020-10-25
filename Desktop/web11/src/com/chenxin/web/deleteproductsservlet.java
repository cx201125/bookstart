package com.chenxin.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.service.productservice;

/**
 * Servlet implementation class deleteproductsservlet
 */
public class deleteproductsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> Map = request.getParameterMap();
		List<Object> list=new ArrayList<Object>();
		Set<String> keySet = Map.keySet();
		for (String string : keySet) {
			String[] strings = Map.get(string);
			for (String string2 : strings) {
				list.add(string2);
			}
		}
		productservice service=new productservice();
		boolean f=service.delectproductsservice(list);
		if(!f){
			request.setAttribute("shibais", "删除失败");
			request.getRequestDispatcher("producthoutai").forward(request, response);
		}else{
		  response.sendRedirect("producthoutai");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
