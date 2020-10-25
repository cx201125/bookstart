package com.chenxin.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chenxin.dao.ProductDao;
import com.chenxin.domain.Dingdan;
import com.chenxin.domain.Leibie;
import com.chenxin.domain.LoginUser;
import com.chenxin.domain.Pagebean;
import com.chenxin.domain.RegisterUser;
import com.chenxin.domain.Tushu;
import com.chenxin.utils.C3p0util;
import com.chenxin.utils.Shiwutil;


public class ProductService {
	//创建dao层对象
	 ProductDao dao=new ProductDao();
	 //注册
	public boolean registerserver(RegisterUser user1) {
		boolean f=true;
		try {
			dao.registerdao(user1);
		} catch (SQLException e) {
			e.printStackTrace();
			f=false;
			
		}
		 return f;
	}
	//传递查询电话的参数
	public boolean dianhuaservice(String dianhua) {
		
		
		return	dao.dianhuadao(dianhua);

}
	//传递查询登录的参数
	public LoginUser loginservice(String dianhua, String password) {
		
		return dao.logindao(dianhua,password);
	}
	//传递搜索参数
	public List<Object> searchservice(String shousuo) {
	
		return dao.searchdao(shousuo);
	}
	//传递最新商品参数
	public List<Tushu> findnewtushuservice() {
		
		 return dao.findnewtushudao();
	}
	//传递特价商品
	public List<Tushu> findbargaintushuservice() {
		// TODO Auto-generated method stub
		 return dao.findbargaintushudao();
	}
	//传递热销商品
	public List<Tushu> findheattushuservice() {
		// TODO Auto-generated method stub
		return dao.findheattushudao();
	}
	//查询全部类别
	public List<Leibie> findallleibieservice() {
		
		return dao.findallleibiedao();
	}
	//封装pagebean
	public Pagebean Oneleibielimit(int onepage,int dangqianpage,String Leibie_ID) {
	Pagebean<Tushu> pagebean=new Pagebean();
	//封装当前页数
	pagebean.setDangqianpage(dangqianpage);
	//封装每一页的商品个数
	pagebean.setOnepage(onepage);
   
	
	//每一个类别一共有多少个商品
	 int allproduct=dao.findoneleibieallproduct(Leibie_ID);
	  pagebean.setAllproduct(allproduct);

	//总页数

	int zongpage=(int)Math.ceil(1.0*allproduct/onepage);
	  pagebean.setZongpage(zongpage);
	  
	//每一页存的数据
	int index=(dangqianpage-1)*onepage;
	List<Tushu> onepageproduct=dao.findonelimitproduct(index,onepage,Leibie_ID);
	pagebean.setOnepageproduct(onepageproduct);
	
		return pagebean;
	}
	//插入实名信息
	public boolean insertrealnameservice(LoginUser user, String user_ID) {
		
		return dao.insertrealnamedao(user,user_ID);
	}
	//根据ID查图书
	public Tushu findalltushubyid(String Tushu_ID) {
		
		return dao.findtushubyiddao(Tushu_ID);
	}
	//插入订单
	public boolean insertdingdanservice(Dingdan dingdan) {
		boolean f=true;
		Shiwutil.MysetAutoComnmit();
		Connection myconnection = Shiwutil.Myconnection();
		try {
			
			dao.insertdingdandao( myconnection,dingdan);
			dao.insertdingdanxiangdao( myconnection,dingdan);
		} catch (SQLException e) {
			Shiwutil.Myrollback();
			f=false;
			e.printStackTrace();
		}finally {
			Shiwutil.Mycommit();
		}
		
		    return f;
	}
	//插入订单项
	public boolean indertsjrxingxiservice(Dingdan dingdan,String dingdan_ID) {
		return dao.insertsjrxingxidao(dingdan,dingdan_ID);
		
	}
	//根据订单userid查所有订单
	public List<Dingdan> findalldingdanbyuidservice(long user_id) {
		
		return dao.findalldingdanbyuiddao(user_id);
	}
	//根据订单ID查所有订单项
	public 	List<Map<String, Object>>  findalldingdanxiangbyidservice(String dingdan_id){
		return dao.findalldingdanxiangbyiddao(dingdan_id);
		
	}
	//疯转pagebean用于分页查询
	public Pagebean allproductlimit(int onepage, int dangqianpage) {
		Pagebean<Tushu> pagebean=new Pagebean();
		//封装当前页数
		pagebean.setDangqianpage(dangqianpage);
		//封装每一页的商品个数
		pagebean.setOnepage(onepage);
	   
		
		//一共有多少个商品
		 int allproduct=dao.findproduccount();
		  pagebean.setAllproduct(allproduct);

		//总页数

		int zongpage=(int)Math.ceil(1.0*allproduct/onepage);
		  pagebean.setZongpage(zongpage);
		  
		//每一页存的数据
		int index=(dangqianpage-1)*onepage;
		List<Tushu> onepageproduct=dao.findlimitproduct(index,onepage);
		pagebean.setOnepageproduct(onepageproduct);
		
			return pagebean;
	}
	
}























