package com.chenxin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Leibiebean;
import com.chenxin.service.productservice;

/**
 * Servlet implementation class findallleibieservlet
 */
public class findallleibieservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productservice service=new productservice();
		List<Leibiebean> allleibie = service.AllLeibieservice();
		request.setAttribute("leibie", allleibie);
		request.getRequestDispatcher("leibie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
