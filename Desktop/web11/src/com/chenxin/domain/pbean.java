package com.chenxin.domain;

import java.util.Date;

public class pbean {
private int tushu_ID;//图书ID
private String Tushu_tsm;//图书名
private String Tushu_zz;//图书作者
private String Tushu_cbs;//出版社
private Date Tushu_cbrq;//出版日期
private int Tushu_jg;//图书价格
private Float Tushu_zkl;//折扣
private  int Tushu_zys;//总页数
private Date Tushu_sjsj;//上架时间
private int Tushu_kcl;//库存量
private String Tushu_images;//图片
private int Tushu_zt;//图书状态
private int Leibie_ID;//图书ID
private String Tushu_lrjj;


@Override
public String toString() {
	return "pbean [tushu_ID=" + tushu_ID + ", Tushu_tsm=" + Tushu_tsm + ", Tushu_zz=" + Tushu_zz + ", Tushu_cbs="
			+ Tushu_cbs + ", Tushu_cbrq=" + Tushu_cbrq + ", Tushu_jg=" + Tushu_jg + ", Tushu_zkl=" + Tushu_zkl
			+ ", Tushu_zys=" + Tushu_zys + ", Tushu_sjsj=" + Tushu_sjsj + ", Tushu_kcl=" + Tushu_kcl
			+ ", Tushu_images=" + Tushu_images + ", Tushu_zt=" + Tushu_zt + ", Leibie_ID=" + Leibie_ID
			+ ", Tushu_lrjj=" + Tushu_lrjj + "]";
}
public pbean() {
	
}
public String getTushu_lrjj() {
	return Tushu_lrjj;
}
public void setTushu_lrjj(String tushu_lrjj) {
	Tushu_lrjj = tushu_lrjj;
}
public int getLeibie_ID() {
	return Leibie_ID;
}
public void setLeibie_ID(int leibie_ID) {
	Leibie_ID = leibie_ID;
}
public int getTushu_zt() {
	return Tushu_zt;
}
public void setTushu_zt(int tushu_zt) {
	Tushu_zt = tushu_zt;
}
public String getTushu_images() {
	return Tushu_images;
}
public void setTushu_images(String tushu_images) {
	Tushu_images = tushu_images;
}
public int getTushu_ID() {
	return tushu_ID;
}
public void setTushu_ID(int tushu_ID) {
	this.tushu_ID = tushu_ID;
}
public String getTushu_tsm() {
	return Tushu_tsm;
}
public void setTushu_tsm(String tushu_tsm) {
	Tushu_tsm = tushu_tsm;
}
public String getTushu_zz() {
	return Tushu_zz;
}
public void setTushu_zz(String tushu_zz) {
	Tushu_zz = tushu_zz;
}
public String getTushu_cbs() {
	return Tushu_cbs;
}
public void setTushu_cbs(String tushu_cbs) {
	Tushu_cbs = tushu_cbs;
}
public Date getTushu_cbrq() {
	return Tushu_cbrq;
}
public void setTushu_cbrq(Date tushu_cbrq) {
	Tushu_cbrq = tushu_cbrq;
}
public int getTushu_jg() {
	return Tushu_jg;
}
public void setTushu_jg(int tushu_jg) {
	Tushu_jg = tushu_jg;
}
public Float getTushu_zkl() {
	return Tushu_zkl;
}
public void setTushu_zkl(Float tushu_zkl) {
	Tushu_zkl = tushu_zkl;
}
public int getTushu_zys() {
	return Tushu_zys;
}
public void setTushu_zys(int tushu_zys) {
	Tushu_zys = tushu_zys;
}
public Date getTushu_sjsj() {
	return Tushu_sjsj;
}
public void setTushu_sjsj(Date tushu_sjsj) {
	Tushu_sjsj = tushu_sjsj;
}
public int getTushu_kcl() {
	return Tushu_kcl;
}
public void setTushu_kcl(int tushu_kcl) {
	Tushu_kcl = tushu_kcl;
}

}
