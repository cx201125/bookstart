package com.chenxin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Tushu;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class ShoppingcartServlet
 */
public class ShoppingcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Tushu_ID=request.getParameter("Tushu_ID");//
		String dizhi = request.getParameter("dizhi");
		if(dizhi!=null){
		if(dizhi.equals("Index")){
			//参数是在主页过来的时候
			request.setAttribute("dizhi",dizhi);
		}else if(dizhi.equals("Oneleibie")){
			//参数是在类别过来的时候
			String dangqianpage=request.getParameter("dangqianpage");
			request.setAttribute("dizhi", dizhi);
			request.setAttribute("dangqianpage", dangqianpage);
		}
		}
		ProductService service=new ProductService();
		Tushu tushu=service.findalltushubyid(Tushu_ID);
		
		float jg=tushu.getTushu_jg();//计算价格
	    float zk = tushu.getTushu_zkl();
	    float round = Math.round(jg*zk*100)/100;
	    
		request.setAttribute("tushu", tushu);
		request.setAttribute("jg", round);
		
		
		
		String tids=Tushu_ID;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if("tids".equals(cookie.getName())){
				tids = cookie.getValue();//1-3-2
			String[] split = tids.split("-");//{1,3,2}
			List<String> arrlist=Arrays.asList(split);
			LinkedList<String> linlist=new LinkedList<String>(arrlist);//{1,3,2}
			if(linlist.contains(Tushu_ID)){
				linlist.remove(Tushu_ID);
				linlist.add(Tushu_ID);
			}else{
				linlist.add(Tushu_ID);
			}
		    StringBuffer buffer=new StringBuffer();
		    for (String string : linlist) {
				buffer.append(string);
				buffer.append("-");
			}
		    tids = buffer.substring(0,buffer.length()-1);
				}
			}
			
		}
		  Cookie cookie=new Cookie("tids",tids);
		  cookie.setMaxAge(1000*60*60*24);
		  response.addCookie(cookie);
		
		
	    request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);;
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
