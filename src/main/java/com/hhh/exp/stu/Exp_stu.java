package com.hhh.exp.stu;

import com.hhh.exp.exp_pub.Exp_pub;
import com.hhh.exp.user.User;

public class Exp_stu {
	public int id;
	public int stuid;
	public int expid;
	public String time; 
	public User user;
	public Exp_pub exp_pub;

	public Exp_stu(int stuid, int expid, String time) {
		super();
		this.stuid = stuid;
		this.expid = expid;
		this.time = time;
	}

	public Exp_stu(int id, int stuid, int expid, String time, User user, Exp_pub exp_pub) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.expid = expid;
		this.time = time;
		this.user = user;
		this.exp_pub = exp_pub;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public int getExpid() {
		return expid;
	}

	public void setExpid(int expid) {
		this.expid = expid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exp_pub getExp_pub() {
		return exp_pub;
	}

	public void setExp_pub(Exp_pub exp_pub) {
		this.exp_pub = exp_pub;
	}

	@Override
	public String toString() {
		return "Exp_stu [id=" + id + ", stuid=" + stuid + ", expid=" + expid + ", time=" + time + ", user=" + user
				+ ", exp_pub=" + exp_pub + "]";
	}

	
}
