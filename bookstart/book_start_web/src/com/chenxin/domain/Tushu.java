package com.chenxin.domain;

import java.util.Date;

public class Tushu {
	
	private int Tushu_ID;//图书ID
	private String Tushu_tsm;//图书名
	private String Tushu_zz;//图书作者
	private String Tushu_cbs;//图书出版社
	private Date Tushu_cbrq;//图书出版日期
	private float Tushu_jg;//图书价格
	private float Tushu_zkl;//图书折扣率
	private  int Tushu_zys;//图书总页数
	private Date Tushu_sjsj;//图书上架时间
	private int Tushu_kcl;//图书库存量
	private String Tushu_images;//图书图片
	private String Tushu_zt;
	private String Tushu_lrjj;
	private int Leibie_ID;//类别ID
	private String Leibie_lbm;//类别名
	private String Leibie_lbsm;//类别说明


	
	
	
	
	public int getLeibie_ID() {
		return Leibie_ID;
	}
	public void setLeibie_ID(int leibie_ID) {
		Leibie_ID = leibie_ID;
	}
	public String getLeibie_lbm() {
		return Leibie_lbm;
	}
	public void setLeibie_lbm(String leibie_lbm) {
		Leibie_lbm = leibie_lbm;
	}
	public String getLeibie_lbsm() {
		return Leibie_lbsm;
	}
	public void setLeibie_lbsm(String leibie_lbsm) {
		Leibie_lbsm = leibie_lbsm;
	}
	public int getTushu_ID() {
		return Tushu_ID;
	}
	public void setTushu_ID(int tushu_ID) {
		Tushu_ID = tushu_ID;
	}
	public String getTushu_zt() {
		return Tushu_zt;
	}
	public void setTushu_zt(String tushu_zt) {
		Tushu_zt = tushu_zt;
	}
	public String getTushu_lrjj() {
		return Tushu_lrjj;
	}
	public void setTushu_lrjj(String tushu_lrjj) {
		Tushu_lrjj = tushu_lrjj;
	}
	
	public String getTushu_images() {
		return Tushu_images;
	}
	public void setTushu_images(String tushu_images) {
		Tushu_images = tushu_images;
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
	public float getTushu_jg() {
		return Tushu_jg;
	}
	public void setTushu_jg(float tushu_jg) {
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
