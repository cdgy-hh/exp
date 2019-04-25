package com.hhh.exp.exp_pub;

public class Exp_pub {
	public int expid;
	public int typeid;
	public String title;
	public String content;
	public int pubid;
	public String pub_time;
	public String end_time;
	public String status;
	public String url;
	public int num;
	
	public Exp_pub() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Exp_pub(int expid, int typeid, String title, String content, int pubid, String pub_time, String end_time,
			String status, String url, int num) {
		super();
		this.expid = expid;
		this.typeid = typeid;
		this.title = title;
		this.content = content;
		this.pubid = pubid;
		this.pub_time = pub_time;
		this.end_time = end_time;
		this.status = status;
		this.url = url;
		this.num = num;
	}

	
	public Exp_pub(int typeid, String title, String content, int pubid, String pub_time, String end_time, String status,
			String url, int num) {
		super();
		this.typeid = typeid;
		this.title = title;
		this.content = content;
		this.pubid = pubid;
		this.pub_time = pub_time;
		this.end_time = end_time;
		this.status = status;
		this.url = url;
		this.num = num;
	}


	public int getExpid() {
		return expid;
	}

	public void setExpid(int expid) {
		this.expid = expid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPubid() {
		return pubid;
	}

	public void setPubid(int pubid) {
		this.pubid = pubid;
	}

	public String getPub_time() {
		return pub_time;
	}

	public void setPub_time(String pub_time) {
		this.pub_time = pub_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Exp_pub [expid=" + expid + ", typeid=" + typeid + ", title=" + title + ", content=" + content
				+ ", pubid=" + pubid + ", pub_time=" + pub_time + ", end_time=" + end_time + ", status="
				+ status + ", url=" + url + ", num=" + num + "]";
	}
	
	
}
