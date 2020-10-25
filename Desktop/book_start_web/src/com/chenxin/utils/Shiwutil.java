package com.chenxin.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * @author 处理事务的工具类
 *
 */
public class Shiwutil {
private static ComboPooledDataSource com=new ComboPooledDataSource();//创建连接池对象
private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();//创建集合
/**
 * 连接池获取Connection对象
 * @returnConnection
 */
public static Connection getconnection(){
	Connection conn=null;
		try {
			conn=com.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  return conn;
}
/**
 * 自己的Connection对象
 * @returnConnection
 */
public static Connection Myconnection(){
	     Connection conn=tl.get();   
	     if(conn==null){
	    	conn=getconnection();
	        tl.set(conn);
	     }
	     return conn;
}
/**
 * 开启事务
 */
public static void MysetAutoComnmit(){
	try {
		Myconnection().setAutoCommit(false);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * 回滚事务
 */
public static void Myrollback(){
	try {
		Myconnection().rollback();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * 提交事务
 */
public static void Mycommit(){
	try {
		Myconnection().commit();
		Myconnection().close();
		tl.remove();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
