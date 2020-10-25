package com.chenxin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Leibiebean;
import com.chenxin.domain.pagebean;
import com.chenxin.domain.pbean;
import com.chenxin.service.productservice;


public class producthoutaiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		//全部商品
		productservice service=new productservice();
		//当前页数
		
		String dangqianpagestr=request.getParameter("dangqianpage");
		int dangqianpage=1;
		if(dangqianpagestr!=null){
		dangqianpage=Integer.parseInt(dangqianpagestr);
		}
		//一页有多少个商品
		int onepage=12;
		
		pagebean<pbean> pagebean= service.AllproductBypageservice(dangqianpage,onepage);
		
		request.setAttribute("Allproduct", pagebean);
		
		
		
		
		
		
		
	
		
		//把全部分类放在域中
		productservice Leibie=new productservice();
		List<Leibiebean> list1=Leibie.AllLeibieservice();
		request.setAttribute("Allleibiefind", list1);
		request.getRequestDispatcher("spgl.jsp").forward(request, response);;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
