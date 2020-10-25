package com.chenxin.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Pagebean;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class AllproductServlet
 */
public class AllproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//当前页数
		 int dangqianpage=1;
		 
		String dangqianpagestr=request.getParameter("dangqianpage");
		if(dangqianpagestr!=null){
		dangqianpage=Integer.parseInt(dangqianpagestr);
		}
		int onepage=24;
		
		 ProductService service=new ProductService();
		 Pagebean pagebean=service.allproductlimit(onepage,dangqianpage);
		
		 request.setAttribute("oneleibieproduct", pagebean);
		 request.getRequestDispatcher("allproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
