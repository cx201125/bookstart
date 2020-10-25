package com.chenxin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Leibiebean;
import com.chenxin.service.productservice;

/**
 * Servlet implementation class updateleibieservlet
 */
public class updateleibieservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Leibie_ID = request.getParameter("Leibei_ID");
		String Leibie_lbm=request.getParameter("Leibie_lbm");
		
		productservice service=new productservice();
		boolean f=service.updateleibiebyidservice(Leibie_ID,Leibie_lbm);
		
		if(!f){
			request.setAttribute("ggshibai", "更改失败");
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
