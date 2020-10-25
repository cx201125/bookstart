package com.chenxin.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.service.ProductService;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String shousuo=request.getParameter("shousuo");
		
		
		ProductService service=new ProductService();
		
		List<Object> list=service.searchservice(shousuo);
		//创建Gson对象
		Gson gson=new Gson();
		//解析Gson
		String str=gson.toJson(list);
		
		response.setContentType("text/html; charset=UTF-8");
		//把解析的json格式的字符串传给首页
		response.getWriter().write(str);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
