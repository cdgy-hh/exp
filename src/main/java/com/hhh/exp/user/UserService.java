package com.hhh.exp.user;


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
}
