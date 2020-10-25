package com.chenxin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.service.productservice;

/**
 * Servlet implementation class addleibieservlet
 */
public class addleibieservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String leibie_lbm = request.getParameter("Leibie_lbm");
		System.out.println(leibie_lbm);
		String leibie_lbsm = request.getParameter("Leibie_lbsm");
		System.out.println(leibie_lbsm);
		productservice service=new productservice();
		boolean f=service.addleibieservice(leibie_lbm,leibie_lbsm);
		System.out.println(f);
		if(!f){
			request.setAttribute("shibai", "类别添加失败");
			
		}else{
			request.setAttribute("chenggong", "类别添加成功");
		}
		request.getRequestDispatcher("addleibie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
