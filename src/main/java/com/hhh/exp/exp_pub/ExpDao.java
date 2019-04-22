package com.hhh.exp.exp_pub;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpDao {
    public List<Exp_pub> OnlineExp();
	
	public int AddOnlineExp(Exp_pub exp);
	
	public int UpdateOnlineExp(int expid);
}
