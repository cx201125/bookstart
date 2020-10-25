package com.chenxin.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chenxin.domain.Tradecart;

/**
 * Servlet implementation class DelectSubTradeServlet
 */
public class DelectSubTradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Tushu_IDstr = request.getParameter("Tushu_ID");
		
		int Tushu_ID = Integer.parseInt(Tushu_IDstr);
		HttpSession session = request.getSession();
		Tradecart attribute = (Tradecart) session.getAttribute("tradecart");
		float subtotal = attribute.getTushumap().get(Tushu_ID).getSubtotal();
		attribute.getTushumap().remove(Tushu_ID);
		float total = attribute.getTotal();
	    float total1=total-subtotal;
	    attribute.setTotal(total1);
		if(attribute.getTushumap().size()==0){
			session.removeAttribute("tradecart");
		}
		request.getRequestDispatcher("tradecart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
