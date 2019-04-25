package com.hhh.exp.stu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

public interface StuDao {

	@Mapper
	public List<Exp_stu> StuExp();
	
	public int InsertExp(Exp_stu stu);
	
	public int CancelExp(int id);
	
}
