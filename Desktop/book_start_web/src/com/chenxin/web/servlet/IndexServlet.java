package com.chenxin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Tushu;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service=new ProductService();
		//获得最新商品，并且存到request域当中
		List<Tushu> newlist=service.findnewtushuservice();
		request.setAttribute("newtushu", newlist);
		//获得特价商品，并且存到request域当中
		List<Tushu> bargainlist=service.findbargaintushuservice();
		request.setAttribute("bargaintushu", bargainlist);
		//获得热销商品，并且存到request域当中
		List<Tushu> heatlist=service.findheattushuservice();
		request.setAttribute("heattushu", heatlist);
		response.setContentType("text/html; charset=UTF-8");
		
	
		//在cookie中取出浏览记录ID
		Cookie[] cookies = request.getCookies();
		List<Tushu> arrlist=new ArrayList<Tushu>();
		for (Cookie cookie : cookies) {
			if("tids".equals(cookie.getName())){
			String value = cookie.getValue();//1-2-3
			String[] split = value.split("-");//[1,2,3]
			
		for(int i=split.length-1;i>=0;i--){
		Tushu tushu = service.findalltushubyid(split[i]);
			arrlist.add(tushu);
			if(arrlist.size()>=12) {
				arrlist.remove(arrlist.size()-1);
			}
		}
			}
			
		}
		
		 request.setAttribute("arrlist", arrlist);
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
