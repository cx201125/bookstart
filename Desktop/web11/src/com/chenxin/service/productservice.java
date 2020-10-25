package com.chenxin.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.chenxin.dao.productdao;
import com.chenxin.domain.Dingdan;
import com.chenxin.domain.Leibiebean;
import com.chenxin.domain.insertbean;
import com.chenxin.domain.pagebean;
import com.chenxin.domain.pbean;
import com.chenxin.domain.vobean;

public class productservice {
//查询全部商品
	public List<pbean> Allproductservice() {
		productdao dao=new productdao();
		List<pbean> list=null;
		try {
			list = dao.Allproductdao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	//查询所有分类
	public List<Leibiebean> AllLeibieservice() {
		productdao Leibie=new productdao();
		List<Leibiebean> list=null;
		try {
			list = Leibie.AllLeibiedao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
//传递封装好的参数
	public void insertproductservice(insertbean insertbean){
		 
		 productdao dao=new productdao();
		try {
			dao.insertproductdao(insertbean);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

//删除商品
	public void removeproductservice(String tushu_ID) {
		int id=Integer.parseInt(tushu_ID);
		productdao dao=new productdao();
		try {
			dao.removeproductdao(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//查询单个商品
	public pbean Oneproductservice(String tushu_ID, pbean pbean) {
		int id=Integer.parseInt(tushu_ID);
		productdao dao=new productdao();
		pbean=null;
		try {
		pbean=dao.Oneproductdao(id,pbean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pbean;

	}

//传递要查询的条件
	public List<pbean> findproductservice(vobean vobean) {
		productdao dao=new productdao();
		List<pbean> list=null;
		try {
			list = dao.findproductdao(vobean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    return list;
	}

//传递更改参数
	public void inputproductservice(insertbean insertbean) {
		productdao dao=new productdao();
	  
		dao.inputproductdao(insertbean);
	
		 
		
	}
//
	public pagebean AllproductBypageservice(int dangqianpage,int  onepage) {
		pagebean pagebean=new pagebean();
		//当前页数

		pagebean.setDangqianpage(dangqianpage);
 	  //一页有多少个

		pagebean.setOnepage(onepage);
		//一共有多少个商品

		productdao dao=new productdao();
		int  Allproduct = 0;
		try {
			  Allproduct= dao.Allproductvaluedao();
			pagebean.setAllproduct(Allproduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//总页数
//		private int  zongpage;
		int zongpage=(int) Math.ceil(1.0*Allproduct/onepage);
		pagebean.setZongpage(zongpage);
		
		//每一页存的数据
//		private List<T> onepageproduct =new ArrayList<T>();
		int index=(dangqianpage-1)*onepage;
		List<pbean> list=null;
		try {
			list=dao.onepageproduct(index,onepage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pagebean.setOnepageproduct(list);
		return pagebean;
		
	}

//类别分页查询
	public pagebean<pbean> findAllproductBypageservice(int dangqianpage, int onepage,
			vobean vobean) {
		pagebean pagebean=new pagebean();
		//当前页数

		pagebean.setDangqianpage(dangqianpage);
 	  //一页有多少个

		pagebean.setOnepage(onepage);
		//一共有多少个商品

		productdao dao=new productdao();
		int  Allproduct = 0;
		try {
			Allproduct= dao.fandAllproductvaluedao(vobean);
			   pagebean.setAllproduct(Allproduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//总页数
//		private int  zongpage;
		int zongpage=(int) Math.ceil(1.0*Allproduct/onepage);
		pagebean.setZongpage(zongpage);
		
		//每一页存的数据
//		private List<T> onepageproduct =new ArrayList<T>();
		int index=(dangqianpage-1)*onepage;
		List<pbean> list=null;
		try {
			list=dao.findonepageproduct(index,onepage,vobean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  pagebean.setOnepageproduct(list);
		  return pagebean;
	}

//根据类别id删除指定类别
	public boolean deleteleibiebuidservice(String parameter) {
		
		productdao dao=new productdao();
		  
		return dao.deleteleibiebuiddao(parameter);
	}

//根据id更改类别
	public boolean updateleibiebyidservice(String leibie_ID,String leibie_lbm) {
		productdao dao=new productdao();
		return dao.updateleibiebyiddao(leibie_ID,leibie_lbm);
	}

//根据id查询类别
	public Leibiebean findleibiebyidservice(String leibie_ID) {
		productdao dao=new productdao();
		return dao.findleibiebyiddao(leibie_ID);
	}

//添加类别
	public boolean addleibieservice(String leibie_lbm, String leibie_lbsm) {
		productdao dao=new productdao();
		return dao.addleibiedao(leibie_lbm,leibie_lbsm);
	}

//查询所有类别
	public List<Dingdan> findalldingdanservice() {
		productdao dao=new productdao();
		return dao.findalldingdandao();
	}
//批量删除
	public boolean delectproductsservice(List<Object> list) {
		
		productdao dao=new productdao();
		return dao.delectproductsdao(list);
	} 
}
