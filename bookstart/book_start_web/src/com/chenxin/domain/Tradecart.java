package com.chenxin.domain;

import java.util.HashMap;
import java.util.Map;

public class Tradecart {
	
private Map<Integer,SubTrade> tushumap=new HashMap<Integer, SubTrade>();
private float total;


public Map<Integer, SubTrade> getTushumap() {
	return tushumap;
}
public void setTushumap(Map<Integer, SubTrade> tushumap) {
	this.tushumap = tushumap;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
}
