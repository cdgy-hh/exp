package com.hhh.exp.exp_pub;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExpDao {
    public List<Exp_pub> AllExp();
	
	public int AddExp(Exp_pub exp);
	
	public int UpdateExp(Exp_pub exp);
	
	public int DeleteExp(int expid);
}
