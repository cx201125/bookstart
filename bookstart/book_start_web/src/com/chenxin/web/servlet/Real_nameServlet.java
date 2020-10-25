package com.chenxin.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chenxin.domain.LoginUser;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class Real_nameServlet
 */
public class Real_nameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_ID=request.getParameter("user_ID");
		LoginUser user=new LoginUser();
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		ProductService service=new ProductService();
		
		boolean f=service.insertrealnameservice(user,user_ID);
		
		if(f){
			response.sendRedirect("Index");
		}else{
			response.sendRedirect("failure.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
