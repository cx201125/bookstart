package com.chenxin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chenxin.domain.Dingdan;
import com.chenxin.domain.Leibiebean;
import com.chenxin.domain.insertbean;
import com.chenxin.domain.pbean;
import com.chenxin.domain.vobean;
import com.chenxin.utils.C3p0util;

public class productdao {
  //查询所有商品
	public List<pbean> Allproductdao() throws SQLException {
		QueryRunner que=new QueryRunner(C3p0util.getDataSource());
		String sql="select * from nettushu";
		List<pbean> list=que.query(sql, new BeanListHandler<pbean>(pbean.class));
		return list;
	}
	public List<Leibiebean> AllLeibiedao() throws SQLException {
		//查询类别所有商品
		QueryRunner que=new QueryRunner(C3p0util.getDataSource());
		String sql="select * from netleibie";
		List<Leibiebean> list=que.query(sql, new BeanListHandler<Leibiebean>(Leibiebean.class));
		return list;
	}
	//添加操作
	     public void insertproductdao(insertbean insertbean) throws SQLException {
		 String sql="insert into nettushu values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 QueryRunner que=new QueryRunner(C3p0util.getDataSource());
		 que.update(sql,null,insertbean.getTushutsm(),insertbean.getTushuzz(),insertbean.getTushucbs(),insertbean.getTushucbrq(),
				 insertbean.getTushujg() ,insertbean.getTushuzkl(),insertbean.getTushuzys(),insertbean.getTushusjsj(),insertbean.getTushukcl(),
				 insertbean.getTushuzt(),insertbean.getTushuimages(),insertbean.getLeibieID(),insertbean.getTushulrjj());
		 
	}
	     //删除操作
		public void removeproductdao(int id) throws SQLException {
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="delete from nettushu where Tushu_ID=?";
			que.update(sql,id);
		}
		//查询单个商品
		public pbean Oneproductdao(int id, pbean pbean) throws SQLException {
			// TODO Auto-generated method stub
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="select * from nettushu where Tushu_ID=?";
			pbean bean=que.query(sql, new BeanHandler<pbean>(pbean.class),id);
			return bean;
		}
		//查询带条件的商品
		public List<pbean> findproductdao(vobean vobean) throws SQLException {
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="select * from nettushu where 1=1";
			List<String> list=new ArrayList<>();
			if(vobean!=null&&!vobean.getShangpinname().trim().equals("")){
				sql+=" and Tushu_tsm like ?";
				list.add("%"+vobean.getShangpinname().trim()+"%");
			}
			if(vobean!=null&&!vobean.getIshod().equals("")){
				sql+=" and Tushu_zt=?";
				list.add(vobean.getIshod());
			}
			if(vobean!=null&&!vobean.getShangpinleibie().equals("")){
				sql+=" and Leibie_ID=?";
				list.add(vobean.getShangpinleibie());
			}
			List<pbean> listpbean=que.query(sql, new BeanListHandler<pbean>(pbean.class),list.toArray());
			        return listpbean;
		}
		//更改商品
		public void inputproductdao(insertbean insertbean){
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="update nettushu set Tushu_tsm=?,Tushu_zz=?,Tushu_cbs=?,Tushu_cbrq=?,Tushu_jg=?,"
					+ "Tushu_zkl=?,Tushu_zys=?,Tushu_sjsj=?,Tushu_kcl=?,Tushu_zt=?,"
					+ "Tushu_images=?,Leibie_ID=?,Tushu_lrjj=? where Tushu_ID=?";
			try {
				que.update(sql, insertbean.getTushutsm(),insertbean.getTushuzz(),insertbean.getTushucbs(),insertbean.getTushucbrq(),
					 insertbean.getTushujg() ,insertbean.getTushuzkl(),insertbean.getTushuzys(),insertbean.getTushusjsj(),insertbean.getTushukcl(),
					 insertbean.getTushuzt(),insertbean.getTushuimages(),insertbean.getLeibieID(),insertbean.getTushulrjj(),insertbean.getTushuID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public int Allproductvaluedao() throws SQLException {
			//获取商品总个数
			
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="select count(*) from nettushu";
			Long all=(Long)que.query(sql, new ScalarHandler<>());
			return all.intValue();
		}
		//查询每一页商品
		public List<pbean> onepageproduct(int index,int onepage) throws SQLException {
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="select * from nettushu limit ?,?";
			List<pbean> list=que.query(sql, new BeanListHandler<pbean>(pbean.class),index,onepage);
			return list;
		}
		//查询搜索的商品总个数
		public int fandAllproductvaluedao(vobean vobean) throws SQLException {
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="select count(*) from nettushu where 1=1";
			List<String> list=new ArrayList<>();
			if(vobean!=null&&!vobean.getShangpinname().trim().equals("")){
				sql+=" and Tushu_tsm like ?";
				list.add("%"+vobean.getShangpinname().trim()+"%");
			}
			if(vobean!=null&&!vobean.getIshod().equals("")){
				sql+=" and Tushu_zt=?";
				list.add(vobean.getIshod());
			}
			if(vobean!=null&&!vobean.getShangpinleibie().equals("")){
				sql+=" and Leibie_ID=?";
				list.add(vobean.getShangpinleibie());
			}
			        
			Long all=(Long)que.query(sql, new ScalarHandler<>(),list.toArray());
			return all.intValue();
		}
		
		//查询搜索的商品
		public List<pbean> findonepageproduct(int index, int onepage, vobean vobean) throws SQLException {
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="select * from nettushu where 1=1";
			List<String> list=new ArrayList<>();
			if(vobean!=null&&!vobean.getShangpinname().trim().equals("")){
				sql+=" and Tushu_tsm like ?";
				list.add("%"+vobean.getShangpinname().trim()+"%");
			}
			if(vobean!=null&&!vobean.getIshod().equals("")){
				sql+=" and Tushu_zt=?";
				list.add(vobean.getIshod());
			}
			if(vobean!=null&&!vobean.getShangpinleibie().equals("")){
				sql+=" and Leibie_ID=?";
				list.add(vobean.getShangpinleibie());
			}
			  sql+=" limit "+index+","+onepage;
			List<pbean> listpbean=que.query(sql, new BeanListHandler<pbean>(pbean.class),list.toArray());
			return listpbean;
		}
		//根据ID删除类别
		public boolean deleteleibiebuiddao(String parameter) {
			boolean f=true;
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="delete from netleibie where Leibie_ID=?";
			try {
				que.update(sql,parameter);
			} catch (SQLException e) {
				f=false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return f;
			
		}
		//根据类别id更改类别名
		public boolean updateleibiebyiddao(String leibie_ID,String leibie_lbm) {
			boolean f=true;
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="update netleibie set Leibie_lbm=? where Leibie_ID=?";
			try {
				que.update(sql,leibie_lbm,leibie_ID);
			} catch (SQLException e) {
				f=false;
				e.printStackTrace();
			}
			return f;
		}
		//根据类别ID查询类别
		public Leibiebean findleibiebyiddao(String leibie_ID) {
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="select * from netleibie where Leibie_ID=?";
			Leibiebean liebie=null;
			try {
				liebie = que.query(sql,new BeanHandler<Leibiebean>(Leibiebean.class),leibie_ID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return liebie;		
			}
		//添加类别
		public boolean addleibiedao(String leibie_lbm, String leibie_lbsm) {
			boolean f=true;
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="insert into netleibie values(?,?,?)";
			try {
				que.update(sql,null,leibie_lbm,leibie_lbsm);
			} catch (SQLException e) {
				f=false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return f;
		}
		//查询所有订单
		public List<Dingdan> findalldingdandao() {
			String sql="select * from netdingdan";
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			List<Dingdan> list=null;
			try {
				list = que.query(sql, new BeanListHandler<Dingdan>(Dingdan.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		public boolean delectproductsdao(List<Object> list) {
			boolean f=true;
			QueryRunner que=new QueryRunner(C3p0util.getDataSource());
			String sql="delete from nettushu where Tushu_ID in(";
			for (Object object : list) {
				sql+="?,";
			}
			String substring = sql.substring(0,sql.length()-1);
			substring+=")";
			System.out.println(substring);
			Object[] array = list.toArray();
			try {
				que.update(substring,array);
			} catch (SQLException e) {
				f=false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return f;
		}
		

}
