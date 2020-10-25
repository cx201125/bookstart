package com.chenxin.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.chenxin.domain.Dingdan;
import com.chenxin.domain.Dingdanxiang;
import com.chenxin.domain.Leibie;
import com.chenxin.domain.LoginUser;
import com.chenxin.domain.RegisterUser;
import com.chenxin.domain.Tushu;
import com.chenxin.utils.C3p0util;
;

public class ProductDao {
 QueryRunner que=new QueryRunner(C3p0util.getDataSource());
 QueryRunner shiwuque=new QueryRunner();
	//吧注册的基本信息添加到数据库
  public void registerdao(RegisterUser user1) throws SQLException {
	  String sql="insert into netuser  values(null,?,?,?,?,?,?,?)";
	  que.update(sql,user1.getUsername(),user1.getPassword(),user1.getDianhua(),user1.getTrue_name(),user1.getNumber(),user1.getMail(),user1.getSex());
		
	}
//查询是否有这个电话，如果没有返回true
public boolean dianhuadao(String dianhua) {
	boolean f;
	String sql="select count(*) from netuser where user_dianhua=?";
	long len=0;
	try {
		len = (long)que.query(sql, new ScalarHandler(),dianhua);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(len==0){
		f=true;
	}else{
		f=false;
	}

	return f;
}
//登录查询返回登录的User对象
public LoginUser logindao(String dianhua, String password) {
	String sql="select * from netuser where user_password=? and user_dianhua=?";
	LoginUser user=null;
	try {
		user= que.query(sql, new BeanHandler<LoginUser>(LoginUser.class),password,dianhua);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   return user;
}
//模糊查询就查询图书名
public List<Object> searchdao(String shousuo) {
 String sql="select * from nettushu where Tushu_tsm like ? limit 0,8";
	
	List<Object> list=null;
	try {
		list= que.query(sql, new ColumnListHandler<Object>("Tushu_tsm"),"%"+shousuo+"%");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return list;
}
//查询最新商品
public List<Tushu> findnewtushudao() {
	String sql="select * from nettushu order by Tushu_sjsj desc limit 0,12";
	List<Tushu> list=null;
	try {
		list = que.query(sql, new BeanListHandler<Tushu>(Tushu.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return list;
}
//查询特价商品
public List<Tushu> findbargaintushudao() {
	
	String sql="select * from nettushu order by Tushu_zkl asc limit 0,12";
	List<Tushu> list=null;
	try {
		list = que.query(sql, new BeanListHandler<Tushu>(Tushu.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return list;
}
//查询热销商品
public List<Tushu> findheattushudao() {
	String sql="select * from nettushu where Tushu_zt=2 limit 0,12";
	List<Tushu> list=null;
	try {
		list = que.query(sql, new BeanListHandler<Tushu>(Tushu.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return list;
}
//查询全部类别
public List<Leibie> findallleibiedao() {
	String sql="select * from netleibie";
	List<Leibie> list=null;
	try {
		list=que.query(sql,new BeanListHandler<Leibie>(Leibie.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    return list;
}
//查询分类商品的总个数
public int findoneleibieallproduct(String Leibie_ID) {
	String sql="select count(*) from netTushu where Leibie_ID=?";
	int intLeibie_ID=Integer.parseInt(Leibie_ID);
	Long all=null;
	try {
		all = (Long) que.query(sql,new ScalarHandler(),intLeibie_ID);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return all.intValue();
}
//查询每一页的商品
public List<Tushu> findonelimitproduct(int index, int onepage,String Leibie_ID) {
	int intLeibie_ID=Integer.parseInt(Leibie_ID);
	String sql="select * from nettushu,netleibie where nettushu.Leibie_ID=? and netleibie.Leibie_ID=? limit ?,?";
	List<Tushu> list=null;
	try {
		list = que.query(sql, new BeanListHandler<Tushu>(Tushu.class),intLeibie_ID,intLeibie_ID,index,onepage);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
//插入实名信息
public boolean insertrealnamedao(LoginUser user, String user_ID) {
	boolean f;
String sql="insert into netuser(user_true_name,user_number,user_mail,user_sex) values(?,?,?,?) where user_id=?";

  int len=0;
try {
	len = que.update(sql,user.getUser_true_name(),user.getUser_number(),user.getUser_mail(),user.getUser_sex(),user_ID);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  if(len==1){
	f=true;
	}else{
    f=false;
	}
  return f;
}
//根据ID查图书商品
public Tushu findtushubyiddao(String Tushu_ID) {
	String sql="select * from nettushu,netleibie where Tushu_ID=? and nettushu.Leibie_ID=netleibie.Leibie_ID";
	Tushu list=null;
	try {
		list=que.query(sql,new BeanHandler<Tushu>(Tushu.class),Tushu_ID);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	     return list;
}
//插入订单
public void insertdingdandao(Connection myconnection ,Dingdan dingdan) throws SQLException {
	
	String sql="insert into netdingdan values(?,?,?,?,?,?,?,?)";
	shiwuque.update(myconnection,sql,dingdan.getDingdan_ID(),dingdan.getUser().getUser_id(),dingdan.getDingdan_sj(),dingdan.getDingdan_zt(),
			dingdan.getDingdan_zj(),dingdan.getDingdan_sjr(),dingdan.getDingdan_sjrdz(),dingdan.getDingdan_sjrdh());
}
//插入每一个订单项
public void insertdingdanxiangdao(Connection myconnection ,Dingdan dingdan) throws SQLException {
	String sql="insert into netdingdanxiang values(?,?,?,?,?)";
	List<Dingdanxiang> list = dingdan.getDingdanlist();
	
	for (Dingdanxiang dingdanxiang : list) {
	shiwuque.update(myconnection,sql,dingdanxiang.getDingdan().getDingdan_ID(),dingdanxiang.getTushu().getTushu_ID(),
				dingdanxiang.getCount(),dingdanxiang.getPrice(),dingdanxiang.getDingdanxiang_ID());
	}
	
	
}
//插入收件人的信息
public boolean insertsjrxingxidao(Dingdan dingdan,String dingdan_ID) {
	boolean f=true;
	String sql="update netdingdan set dingdan_zt=?,dingdan_sjr=?,dingdan_sjrdz=?,dingdan_sjrdh=? where dingdan_ID=?";
	try {
		que.update(sql,1,dingdan.getDingdan_sjr(),dingdan.getDingdan_sjrdz(),dingdan.getDingdan_sjrdh(),dingdan_ID);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		f=false;
		e.printStackTrace();
	}
	return f;
}
public List<Dingdan> findalldingdanbyuiddao(long user_id) {
String sql="select * from netdingdan where user_id=?";
List<Dingdan> list=null;
try {
	list = que.query(sql,new BeanListHandler<Dingdan>(Dingdan.class),user_id);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return list;
}

public 	List<Map<String, Object>>  findalldingdanxiangbyiddao(String dingdan_id){
	String sql="select t.Tushu_tsm,t.Tushu_images,t.Tushu_jg,d.count,d.price "
			+ "from nettushu t,netdingdanxiang d "
			+ "where t.Tushu_ID=d.tushu_ID and d.dingdan_ID=?";
	List<Map<String, Object>> query=null;
	try {
		query = que.query(sql,new MapListHandler(),dingdan_id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	     return query;
	
}
//查询商品总个数
public int findproduccount() {
	String sql="select count(*) from netTushu";
	
	Long all=null;
	try {
		all = (Long) que.query(sql,new ScalarHandler());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return all.intValue();
}

//分页查询所有商品
public List<Tushu> findlimitproduct(int index, int onepage) {
	String sql="select * from nettushu limit ?,?";
	List<Tushu> list=null;
	try {
		list = que.query(sql, new BeanListHandler<Tushu>(Tushu.class),index,onepage);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}












}
