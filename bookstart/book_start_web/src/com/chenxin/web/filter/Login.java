package com.chenxin.web.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.chenxin.domain.LoginUser;
import com.chenxin.service.ProductService;
/**
 * Servlet Filter implementation class Login
 */
public class Login implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest Request=(HttpServletRequest) request;
		Cookie[] cookies = Request.getCookies();
		String dianhua=null;
		String password=null;
		if(cookies!=null) {
		for (Cookie cookie : cookies){
			if("cookiedianhua".equals(cookie.getName())){
			dianhua=URLDecoder.decode(cookie.getValue(), "UTF-8");//对对象进行解码
			}
			if("cookiepassword".equals(cookie.getName())){
				password=cookie.getValue();
			}
		}
		if(dianhua!=null&&password!=null&&dianhua!=""&&password!="."){
			ProductService service=new ProductService();//调用service层对象
			LoginUser user=service.loginservice(dianhua,password);//调用service层对象
			HttpSession session = Request.getSession();
			session.setAttribute("user", user);
		}
	
		}
		
		
		   chain.doFilter(request,response);
		   
		   
		   
		   
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
