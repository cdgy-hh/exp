package com.hhh.exp.exp_pub;

public class Exp_pub {
	public int expid;
	public int typeid;
	public String title;
	public String content;
	public int pubid;
	public String pub_time;
	public String end_time;
	public String exp_status;
	public String url;
	public int time;
	
	public Exp_pub(int expid, int typeid, String title, String content, int pubid, String pub_time, String end_time,
			String exp_status, String url, int time) {
		super();
		this.expid = expid;
		this.typeid = typeid;
		this.title = title;
		this.content = content;
		this.pubid = pubid;
		this.pub_time = pub_time;
		this.end_time = end_time;
		this.exp_status = exp_status;
		this.url = url;
		this.time = time;
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

	public String getExp_status() {
		return exp_status;
	}

	public void setExp_status(String exp_status) {
		this.exp_status = exp_status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Exp_pub [expid=" + expid + ", typeid=" + typeid + ", title=" + title + ", content=" + content
				+ ", pubid=" + pubid + ", pub_time=" + pub_time + ", end_time=" + end_time + ", exp_status="
				+ exp_status + ", url=" + url + ", time=" + time + "]";
	}
	
	
}
