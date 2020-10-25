package com.chenxin.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.chenxin.domain.Dingdan;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class DingdantijiaoServlet
 */
public class DingdantijiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		String dingdan_ID = request.getParameter("dingdan_ID");
		if(parameterMap==null){
			request.setAttribute("shibai", "请填写收货人信息");
			request.getRequestDispatcher("dingdan.jsp").forward(request, response);
			return;
		}
		Dingdan dingdan=new Dingdan();
		try {
			BeanUtils.populate(dingdan, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductService service =new ProductService();
		boolean f = service.indertsjrxingxiservice(dingdan,dingdan_ID);
		if(f){
		String parameter = request.getParameter("optionsRadios");
		String zhifufangshi=null;
		if(parameter.equals("weixing")){
		
		}else{
			zhifufangshi="11";
		}
		request.setAttribute("zhifufangshi",zhifufangshi);
		request.getRequestDispatcher("zhifufangshi.jsp").forward(request, response);
		}else{
			request.setAttribute("goumaishibai", "购买失败");
			request.getRequestDispatcher("dingdan.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
