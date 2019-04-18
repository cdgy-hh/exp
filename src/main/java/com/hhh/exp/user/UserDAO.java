package com.hhh.exp.user;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	public List<Role> selectAllRole();
	
	public List<User> selectAllUser();
	
	public User selectUserByName(String name);
	
	public Role selectRoleByRoleid(int roleid);
	
	public int insertUser(User user);
	
	public int deleteByUserId(int userid);
	
	public int updateUserById(User user);
		
}
