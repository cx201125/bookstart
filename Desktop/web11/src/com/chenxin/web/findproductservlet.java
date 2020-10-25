package com.chenxin.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chenxin.domain.Leibiebean;
import com.chenxin.domain.pagebean;
import com.chenxin.domain.pbean;
import com.chenxin.domain.vobean;
import com.chenxin.service.productservice;



public class findproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String,String[]> map=request.getParameterMap();
		vobean vobean=new vobean();
		try {
			BeanUtils.populate(vobean, map);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//把要查的商品回传
		request.setAttribute("vobean",vobean);
		//把所有商品存放在域中
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
				
				pagebean<pbean> pagebean= service.findAllproductBypageservice(dangqianpage,onepage,vobean);
				
				request.setAttribute("Allproduct", pagebean);
		//把商品类别存放在request域中
		        productservice Leibie=new productservice();
		        List<Leibiebean> list1=Leibie.AllLeibieservice();
		        request.setAttribute("Allleibiefind", list1);
		//转发
		        request.getRequestDispatcher("findproduct.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
