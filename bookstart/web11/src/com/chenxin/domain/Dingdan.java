package com.chenxin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dingdan {
	
	
private String dingdan_ID;//订单——ID
//private LoginUser user;//用户实体
private Date dingdan_sj;//订单时间
private  int dingdan_zt;//订单状态
private float dingdan_zj;//订单总价
private String dingdan_sjr;//订单收件人
private String dingdan_sjrdz;//收件人地址
private String dingdan_sjrdh;//收件人地址
private List<Dingdanxiang> dingdanlist=new ArrayList<Dingdanxiang>();//里面存的购物项





public String getDingdan_ID() {
	return dingdan_ID;
}
public void setDingdan_ID(String dingdan_ID) {
	this.dingdan_ID = dingdan_ID;
}

public Date getDingdan_sj() {
	return dingdan_sj;
}
public void setDingdan_sj(Date dingdan_sj) {
	this.dingdan_sj = dingdan_sj;
}
public int getDingdan_zt() {
	return dingdan_zt;
}
public void setDingdan_zt(int dingdan_zt) {
	this.dingdan_zt = dingdan_zt;
}
public float getDingdan_zj() {
	return dingdan_zj;
}
public void setDingdan_zj(float dingdan_zj) {
	this.dingdan_zj = dingdan_zj;
}
public String getDingdan_sjr() {
	return dingdan_sjr;
}
public void setDingdan_sjr(String dingdan_sjr) {
	this.dingdan_sjr = dingdan_sjr;
}
public String getDingdan_sjrdz() {
	return dingdan_sjrdz;
}
public void setDingdan_sjrdz(String dingdan_sjrdz) {
	this.dingdan_sjrdz = dingdan_sjrdz;
}
public String getDingdan_sjrdh() {
	return dingdan_sjrdh;
}
public void setDingdan_sjrdh(String dingdan_sjrdh) {
	this.dingdan_sjrdh = dingdan_sjrdh;
}
public List<Dingdanxiang> getDingdanlist() {
	return dingdanlist;
}
public void setDingdanlist(List<Dingdanxiang> dingdanlist) {
	this.dingdanlist = dingdanlist;
}

}
