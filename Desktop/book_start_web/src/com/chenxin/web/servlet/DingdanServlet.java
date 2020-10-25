package com.chenxin.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.chenxin.domain.Dingdan;
import com.chenxin.domain.Dingdanxiang;
import com.chenxin.domain.LoginUser;
import com.chenxin.domain.SubTrade;
import com.chenxin.domain.Tradecart;
import com.chenxin.domain.Tushu;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class DingdanServlet
 */
public class DingdanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
	
		HttpSession session = request.getSession();
		
		LoginUser user = (LoginUser) session.getAttribute("user");
		if(user==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		
		
        
         Dingdan dingdan=new Dingdan();
         Tradecart tradecart = (Tradecart) session.getAttribute("tradecart");
//         private long dingdan_ID;//订单——ID
         String string = UUID.randomUUID().toString();
         dingdan.setDingdan_ID(string);
//         private LoginUser user;//用户实体
       
        dingdan.setUser(user);
//         private Date dingdan_sj;//订单时间
        dingdan.setDingdan_sj(new Date());
//         private  int dingdan_zt;//订单状态
        dingdan.setDingdan_zt(0);
//         private float dingdan_zj;//订单总价
        float total = tradecart.getTotal();
        dingdan.setDingdan_zj(total);
//         private String dingdan_sjr;//订单收件人
//         private String dingdan_sjrdz;//收件人地址
//         private String dingdan_shrdh;//收件人地址
//         private List<Dingdanxiang> dingdanlist=new ArrayList<Dingdanxiang>();//里面存的购物项
          List<Dingdanxiang> list=new ArrayList<Dingdanxiang>();
          Map<Integer, SubTrade> tushumap = tradecart.getTushumap();
          ProductService service=new ProductService();
          
         Set<Integer> keySet = tushumap.keySet();
         for (Integer integer : keySet) {
        Dingdanxiang dingdanx=new Dingdanxiang();
		SubTrade value = tushumap.get(integer);
//  		private Dingdan dingdan;//对应的订单ID
      	  dingdanx.setDingdan(dingdan);
//    		private Tushu tushu;//图书实体
      	 
      	  int tushu_ID = value.getTushu().getTushu_ID();
      	 String valueOf = String.valueOf(tushu_ID);
    		Tushu findalltushubyid = service.findalltushubyid(valueOf);
    		dingdanx.setTushu(findalltushubyid);
//  		private int count;//购买数量
  		 int number = value.getNumber();
  		 dingdanx.setCount(number);
//  		private float price;//小计
  		 float subtotal = value.getSubtotal();
  		 dingdanx.setPrice(subtotal);
//  		private long dingdanxiang_ID;//订单项ID
  		 list.add(dingdanx);
		}

     
          dingdan.setDingdanlist(list);
          boolean f= service.insertdingdanservice(dingdan);
          System.out.println(f);
          if(!f){
        	  request.setAttribute("shibai", "订单提交失败");
        	  request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);;
          }else{
        	  session.setAttribute("dingdan", dingdan);
        	  response.sendRedirect("dingdan.jsp");
          }
         
         
         

		




		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
