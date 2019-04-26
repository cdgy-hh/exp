package com.hhh.exp.stu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface StuDao {

	public List<Exp_stu> StuExp(int stuid);
	
	public int InsertExp(Exp_stu stu);
	
	public int CancelExp(int id);
	
}
