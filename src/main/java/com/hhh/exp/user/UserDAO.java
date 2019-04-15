package com.hhh.exp.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	public User selectUserByName(String name);
	
	public Role selectRoleByRoleid(int roleid);
		
}