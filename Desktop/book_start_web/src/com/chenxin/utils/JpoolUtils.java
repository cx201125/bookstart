package com.chenxin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * @author Jedis连接池工具类
 *
 */
public class JpoolUtils {
	
	private static JedisPool pool=null;
	
	static{
	InputStream resourceAsStream = JpoolUtils.class.getClassLoader().getResourceAsStream("Jedispool.properties");
	
	Properties ppt=new Properties();
	try {
		ppt.load(resourceAsStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	JedisPoolConfig config=new JedisPoolConfig();//创建连接池对象
	config.setMaxTotal(Integer.parseInt(ppt.getProperty("MaxTotal")));//设置最大连接个数
	config.setMaxIdle(Integer.parseInt(ppt.getProperty("MaxIdle")));//设置最大闲置个数
	config.setMinIdle(Integer.parseInt(ppt.getProperty("MinIdle")));//设置最小闲置个数
	pool=new JedisPool(config,ppt.getProperty("url"),Integer.parseInt(ppt.getProperty("prot")));
	}
	/**
	 * 获取Jedis对象
	 * @return Jedis
	 */
    public static Jedis getJedis(){
	return pool.getResource();
}
    /**
     * 关闭连接池
     */
    public static void colse(){
    	pool.close();
    }
}
