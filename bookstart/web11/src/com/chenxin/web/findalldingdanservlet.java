package com.chenxin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Dingdan;
import com.chenxin.service.productservice;

/**
 * Servlet implementation class findalldingdanservlet
 */
public class findalldingdanservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productservice service=new productservice();
		List<Dingdan> list=service.findalldingdanservice();
		request.setAttribute("dingdanlist", list);
		request.getRequestDispatcher("dingdan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
