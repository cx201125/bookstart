package com.chenxin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.service.productservice;

/**
 * Servlet implementation class deleteleibieservlet
 */
public class deleteleibieservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("Leibie_ID");
		productservice service=new productservice();
		boolean f = service.deleteleibiebuidservice(parameter);
		if(!f){
			request.setAttribute("shibai", "删除失败");
			request.getRequestDispatcher("findallleibie").forward(request, response);
		}else{
		response.sendRedirect("findallleibie");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
