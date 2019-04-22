package com.hhh.exp.exp_pub;

public class Exp_stu {
	private int id;
	private int stuid;
	private int expid;
	private String time;
	
	public Exp_stu(int id, int stuid, int expid, String time) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.expid = expid;
		this.time = time;
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

	@Override
	public String toString() {
		return "Exp_stu [id=" + id + ", stuid=" + stuid + ", expid=" + expid + ", time=" + time + "]";
	}
	
	
	
}
