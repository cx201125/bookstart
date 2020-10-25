package com.chenxin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Leibiebean;
import com.chenxin.domain.pbean;
import com.chenxin.service.productservice;

/**
 * Servlet implementation class updateproductservlet
 */
public class updateproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查詢单个商品信息
		System.out.println("哈哈哈哈");
		String Tushu_ID=request.getParameter("Tushu_ID");
		pbean pbean=new pbean();
		productservice service=new productservice();
		 pbean=service.Oneproductservice(Tushu_ID,pbean);
		//所有的商品类別
		productservice Leibie=new productservice();
		List<Leibiebean> list=Leibie.AllLeibieservice();
		request.setAttribute("Allleibieupdate", list);
		request.setAttribute("oneproduct", pbean);
		request.getRequestDispatcher("updateproduct.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
