package com.hhh.exp.user;


public class User {

	private int userid;
	private int No;
	private String name;
	private String sex;
	private String phone;
	private String password;
	private int roleid;
	private Role role;

	public User() {
		super();
	}

	public User(int userid, int no, String name, String sex, String phone, String password, int roleid, Role role) {
		super();
		this.userid = userid;
		No = no;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.password = password;
		this.roleid = roleid;
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

	
	
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", No=" + No + ", name=" + name + ", sex=" + sex + ", phone=" + phone
				+ ", password=" + password + ", roleid=" + roleid + ", role=" + role + "]";
	}
	
}
