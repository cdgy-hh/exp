package com.hhh.exp.user;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhh.exp.util.CacheUtil;

@Service
public class UserService{
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CacheUtil cacheUtil;
	
	public User getUserByName(String name) throws Exception {
		User user=null;
		user = userDao.selectUserByName(name);
		if(user!=null) {
			Role role = userDao.selectRoleByRoleid(user.getRoleid());
			user.setRole(role);
		}
		
		return user;
	}
	
	public int insertUser(User user) {
		int res=userDao.insertUser(user);
		return res;
	}
	
	public int deleteUser(int userid) {
		int res=userDao.deleteByUserId(userid);
		return res;
	}
	
	public int updateUser(User user) {
		int res=userDao.updateUserById(user);
		return res;
	}
	
	public List<User> listUserByRoleType(String type){
		List<User> res = new ArrayList<>();
		List<User> temp = userDao.selectAllUser();
		for (User user : temp) {
			Role role = cacheUtil.getRoleById(user.getRoleid());
			if(role.getType().equals(type)) {
				user.setRole(role);
				res.add(user);
			}
		}
		return res;
	}
}
