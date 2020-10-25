package com.chenxin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Leibiebean;
import com.chenxin.service.productservice;


public class findproductfenleiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        //把商品类别存放在request域中
				productservice Leibie=new productservice();
				List<Leibiebean> list=Leibie.AllLeibieservice();
				request.setAttribute("Allleibie", list);
				//转发
				request.getRequestDispatcher("addproduct.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
