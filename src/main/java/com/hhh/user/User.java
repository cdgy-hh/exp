package com.hhh.user;


public class User {

	public int userid;
	public int No;
	public String name;
	public String sex;
	public String phone;
	public String password;
	public Role roleid;

	public User(int userid, int no, String name, String sex, String phone, String password, Role roleid) {
		super();
		this.userid = userid;
		No = no;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.password = password;
		this.roleid = roleid;
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
	public Role getRoleid() {
		return roleid;
	}
	public void setRoleid(Role roleid) {
		this.roleid = roleid;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", No=" + No + ", name=" + name + ", sex=" + sex + ", phone=" + phone
				+ ", password=" + password + ", roleid=" + roleid + "]";
	}
	
}
