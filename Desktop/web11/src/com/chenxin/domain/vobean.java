package com.chenxin.domain;

public class vobean {
private String shangpinname;
private String ishod;
private String shangpinleibie;
private String tushutsm;
private String hhhhh;
public String getTushutsm() {
	return tushutsm;
}
public String getHhhhh() {
	return hhhhh;
}
public void setHhhhh(String hhhhh) {
	this.hhhhh = hhhhh;
}
public void settushutsm(String tushutsm) {
	this.tushutsm = tushutsm;
}
public String getShangpinname() {
	return shangpinname;
}
public void setShangpinname(String shangpinname) {
	this.shangpinname = shangpinname;
}
public String getIshod() {
	return ishod;
}
public void setIshod(String ishod) {
	this.ishod = ishod;
}
public String getShangpinleibie() {
	return shangpinleibie;
}
public void setShangpinleibie(String shangpinleibie) {
	this.shangpinleibie = shangpinleibie;
}
@Override
public String toString() {
	return "vobean [shangpinname=" + shangpinname + ", ishod=" + ishod + ", shangpinleibie=" + shangpinleibie + "]";
}

}
