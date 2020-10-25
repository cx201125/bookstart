package com.chenxin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class Myconvert implements Converter{

	@Override
	public Object convert(Class arg0, Object value) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = null;
			try {
				parse = sdf.parse(value.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//将格式为yyyy-MM-dd转换为Date类型
		
		    return parse;
		
	}

}
