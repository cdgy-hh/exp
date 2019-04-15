package com.hhh.model;

public class User {

	public int userid;
	public int No;
	public String name;
	public String sex;
	public String phone;
	public String password;
	public Role role;
	
	public User() {
		super();
	}
	
	public User(int userid, int no, String name, String sex, String phone, String password, Role role) {
		super();
		this.userid = userid;
		No = no;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	

	
}
