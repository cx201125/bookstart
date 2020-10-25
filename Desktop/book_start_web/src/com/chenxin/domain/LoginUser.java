package com.chenxin.domain;

public class LoginUser {
private long user_id;
private String user_username;
private String user_password;
private String user_dianhua;
private String user_true_name;
private String user_number;
private String user_mail;
private int user_sex;


public String getUser_number() {
	return user_number;
}
public void setUser_number(String user_number) {
	this.user_number = user_number;
}
public long getUser_id() {
	return user_id;
}
public void setUser_id(long user_id) {
	this.user_id = user_id;
}
public String getUser_username() {
	return user_username;
}
public void setUser_username(String user_username) {
	this.user_username = user_username;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String user_password) {
	this.user_password = user_password;
}
public String getUser_dianhua() {
	return user_dianhua;
}
public void setUser_dianhua(String user_dianhua) {
	this.user_dianhua = user_dianhua;
}
public String getUser_true_name() {
	return user_true_name;
}
public void setUser_true_name(String user_true_name) {
	this.user_true_name = user_true_name;
}

public String getUser_mail() {
	return user_mail;
}
public void setUser_mail(String user_mail) {
	this.user_mail = user_mail;
}
public int getUser_sex() {
	return user_sex;
}
public void setUser_sex(int user_sex) {
	this.user_sex = user_sex;
}
}
