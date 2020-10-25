package com.chenxin.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.chenxin.domain.Dingdan;
import com.chenxin.domain.Dingdanxiang;
import com.chenxin.domain.LoginUser;
import com.chenxin.domain.Tushu;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class DingdanFindServlet
 */
public class DingdanFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session域中获取user对象
		LoginUser user  = (LoginUser) session.getAttribute("user");
		ProductService service=new ProductService();
		//所有的的订单
		List<Dingdan> dingdanlist=service.findalldingdanbyuidservice(user.getUser_id());
		//创建一个订单项集合
		
		for (Dingdan dingdan : dingdanlist) {
			String dingdan_ID = dingdan.getDingdan_ID();
        List<Map<String, Object>> findalldingdanxiangbyidservice = service.findalldingdanxiangbyidservice(dingdan_ID);
        List<Dingdanxiang> ddxlist=new ArrayList<Dingdanxiang>();
			for (Map<String, Object> map : findalldingdanxiangbyidservice) {
				Tushu tushu=new Tushu();
				tushu.setTushu_tsm(map.get("Tushu_tsm").toString());
				tushu.setTushu_images(map.get("Tushu_images").toString());
				tushu.setTushu_jg(Float.parseFloat(map.get("Tushu_jg").toString()));
				Dingdanxiang ddx=new Dingdanxiang();
				try {
					//封装图书数据
					//封装订单项数据
					BeanUtils.populate(ddx, map);
					//把图书实体封装到订单项中
					ddx.setTushu(tushu);
					//把订单项封装到订单的List集合中
					ddxlist.add(ddx);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//把订单项集合封装到订单对象中
			dingdan.setDingdanlist(ddxlist);
		}
		//把封装好的订单转发放到request域并且转发
		request.setAttribute("dingdan",dingdanlist);
		request.getRequestDispatcher("finddingdan.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
