package com.chenxin.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chenxin.domain.RegisterUser;
import com.chenxin.service.ProductService;
import com.chenxin.utils.MailUtils;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  Map<String, String[]> parameterMap = request.getParameterMap();
		  ProductService server=new ProductService();
		  
		     RegisterUser user=new RegisterUser();
		  try {
			BeanUtils.populate(user,parameterMap);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  boolean f=server.registerserver(user);
		  
		  if(f){
			  //1收件人  2发送内容 3发送标题
			  boolean sendMail = MailUtils.sendMail(user.getMail(), "恭喜"+user.getTrue_name()+"先生"+"注册成为我公司的会员", "104有限图书公司");
			  if(sendMail) {
				  System.out.println("发送成功");
			  }else {
				  System.out.println("发送失败");
			  }
			   response.sendRedirect("login.jsp");
		  }else{
			   response.sendRedirect("failure.jsp");
		  }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
