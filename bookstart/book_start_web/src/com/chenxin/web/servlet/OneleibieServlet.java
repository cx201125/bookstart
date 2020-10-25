package com.chenxin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Pagebean;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class OneleibieServlet
 */
public class OneleibieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Leibie_ID=request.getParameter("Leibie_ID");
		 int dangqianpage=1;
		 
		String dangqianpagestr=request.getParameter("dangqianpage");
		if(dangqianpagestr!=null){
		dangqianpage=Integer.parseInt(dangqianpagestr);
		}
		int onepage=12;
		
		 ProductService service=new ProductService();
		 Pagebean pagebean=service.Oneleibielimit(onepage,dangqianpage,Leibie_ID);
		
		 request.setAttribute("oneleibieproduct", pagebean);
		 request.getRequestDispatcher("oneleibieproduct.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
