package com.hhh.exp.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	
	@Autowired
	private UserDAO userDao;
	
	public User getUserByName(String name) throws Exception {
		User user=null;
		user = userDao.selectUserByName(name);
		if(user!=null) {
			Role role = userDao.selectRoleByRoleid(user.getRoleid());
			user.setRole(role);
		}
		
		return user;
	}
	
	public boolean insertUser(User user) {
		boolean res=userDao.insertUser(user);
		return res;
	}
}
