package com.hhh.user;

import org.apache.ibatis.session.SqlSession;

public class Userservice implements Userdao{
	
	private SqlSession session;
	public User getUserByName(String name) throws Exception {
		User user=null;
		try {
			user=session.selectOne("UserMybatis.selectUserByName",name);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("获取用户在mybatis层发生了异常");
		}
		return user;
	}
	public Role getRoleid(int roleid) throws Exception {
		Role role=null;
		try {
			role=session.selectOne("UserMybatis.selectRoleByRoleid",roleid);
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("获取用户在mybatis层发生了异常");
		}
		return role;
	}
}
