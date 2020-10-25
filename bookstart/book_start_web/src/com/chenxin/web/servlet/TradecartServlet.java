package com.chenxin.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chenxin.domain.SubTrade;
import com.chenxin.domain.Tradecart;
import com.chenxin.domain.Tushu;
import com.chenxin.service.ProductService;

/**
 * Servlet implementation class TradecareServlet
 */
public class TradecartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Tushu_ID= request.getParameter("Tushu_ID");
		 String numberstr =request.getParameter("count");
		 String dizhi=request.getParameter("dizhi");
		 String dangqianpage=request.getParameter("dangqianpage");
		 
		 if(!numberstr.matches("[1-9]")&&numberstr!=null){
			 request.setAttribute("sbcg", "请输入有效的数量");
			 request.getRequestDispatcher("Shoppingcart?Tushu_ID="+Tushu_ID+"&dizhi="+dizhi+"&dangqianpage="+dangqianpage).forward(request, response);
		 }
		 
		 HttpSession session = request.getSession();
		 Tradecart tradecart=null;
		 
		 tradecart= (Tradecart) session.getAttribute("tradecart");

         if(tradecart==null){
         tradecart=new Tradecart();//创建购物车对象
         }
         
		 SubTrade sub=new SubTrade();//购物项对象
		 
		 ProductService service=new ProductService();
		 Tushu tushu = service.findalltushubyid(Tushu_ID);//商品
		 //封装图书
		 sub.setTushu(tushu);
		 //封装数量
		 int Tushu_IDInt = Integer.parseInt(Tushu_ID);//2
	      SubTrade subTrade = tradecart.getTushumap().get(Tushu_IDInt);
	      int number=0;
	      number=Integer.parseInt(numberstr);
	     if(subTrade!=null){
	     int number1=subTrade.getNumber();
	    	number =number+number1;
	     }
	     sub.setNumber(number);
	     //封装小计
	     float tushu_jg = tushu.getTushu_jg();
         float subtotal=Math.round(tushu_jg*number*10000)/10000;
         sub.setSubtotal(subtotal);
		
	   
         //封装购物项到购物车
        
         Map<Integer, SubTrade> tushumap = tradecart.getTushumap();
         tushumap.put(tushu.getTushu_ID(),sub);
         tradecart.setTushumap(tushumap);
         //封装总计
         Map<Integer, SubTrade> map = tradecart.getTushumap();
         Set<Integer> keySet = map.keySet();
         float total=0f;
         for (Integer integer : keySet) {
         SubTrade subTrade2 = map.get(integer);
		     subTrade2.getSubtotal();
			total+=subTrade2.getSubtotal();
		}
          tradecart.setTotal(total);
      
         session.setAttribute("tradecart", tradecart);
         request.setAttribute("sbcg", "加入购物车成功");
		 
         request.getRequestDispatcher("Shoppingcart?Tushu_ID="+Tushu_ID+"&dizhi="+dizhi+"&dangqianpage="+dangqianpage).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
