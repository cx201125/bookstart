package com.chenxin.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.chenxin.domain.insertbean;
import com.chenxin.domain.pbean;
import com.chenxin.service.productservice;
import com.chenxin.utils.Myconvert;

public class oneupdateproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> strmap=request.getParameterMap();
		
		insertbean insertbean=new insertbean();	
		try {
//转换数据类型
          ConvertUtils.register( new Myconvert(),Date.class);
//把数据封装到bean中
			BeanUtils.populate( insertbean,strmap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       //把参数传递到serivce层
		 productservice service=new productservice();
		 service.inputproductservice(insertbean);
     response.sendRedirect("producthoutai");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
