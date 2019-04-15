package com.hhh.model;

public class Role {
	public int roleid;
	public String type;
	public String grade;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", type=" + type + ", grade=" + grade + "]";
	}
	
}
