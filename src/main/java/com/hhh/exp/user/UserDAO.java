package com.hhh.exp.user;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	public User selectUserByName(String name);
	
	public Role selectRoleByRoleid(int roleid);
	
	public int insertUser(User user);
	
	public int deleteByUserId(int userid);
	
	public int updateUserById(User user);
		
}
