package com.chenxin.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @author C3po连接池工具类
 *
 */
public class C3p0util {
	private static ComboPooledDataSource com=new ComboPooledDataSource();
	/**
	 * 获得DataSource对象
	 */
public static  ComboPooledDataSource getDataSource() {
	               return com;
}
/**
 * 获得Connection对象
 */
public static Connection getConnection() {
	try {
		return com.getConnection();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}
