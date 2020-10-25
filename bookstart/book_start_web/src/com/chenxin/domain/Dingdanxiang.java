package com.chenxin.domain;

public class Dingdanxiang {
private Dingdan dingdan;//对应的订单ID
private Tushu tushu;//图书实体
private int count;//订单数量
private float price;//小计
private long dingdanxiang_ID;//订单项ID
public Dingdan getDingdan() {
	return dingdan;
}
public void setDingdan(Dingdan dingdan) {
	this.dingdan = dingdan;
}
public Tushu getTushu() {
	return tushu;
}
public void setTushu(Tushu tushu) {
	this.tushu = tushu;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public long getDingdanxiang_ID() {
	return dingdanxiang_ID;
}
public void setDingdanxiang_ID(long dingdanxiang_ID) {
	this.dingdanxiang_ID = dingdanxiang_ID;
}
}
