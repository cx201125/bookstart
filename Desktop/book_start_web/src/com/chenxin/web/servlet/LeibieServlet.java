package com.chenxin.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxin.domain.Leibie;
import com.chenxin.service.ProductService;
import com.chenxin.utils.JpoolUtils;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class LeibieServlet
 */
public class LeibieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service=new ProductService();
		String jsonredis=null;
//		//创建连接池对象，或得jedis对象
//	JpoolUtils jsdisPool=new JpoolUtils();
//	Jedis jedis=jsdisPool.getJedis();
//		//获取
//		jsonredis = jedis.get("allleibie");
//		if(jsonredis==null){
//             System.out.println(111);
//			List<Leibie> list=service.findallleibieservice();
//			//把list集合解析成json格式的字符串
//			Gson gson=new Gson();
//			jsonredis = gson.toJson(list);
//			jedis.set("allleibie", jsonredis);
//		}
		List<Leibie> list=service.findallleibieservice();
		//把list集合解析成json格式的字符串
		Gson gson=new Gson();
		jsonredis = gson.toJson(list);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(jsonredis);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
