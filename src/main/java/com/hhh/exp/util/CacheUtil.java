package com.hhh.exp.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hhh.exp.user.Role;
import com.hhh.exp.user.UserDAO;

@Component
public class CacheUtil {
	
	private Map<Integer, Role> roleMap = null;
	
	@Autowired
	private UserDAO userDAO;
	
	public Role getRoleById(int rolerid) {
		Role role = null;
		if(roleMap==null) {
			this.loadRoleMap();
		}
		role = this.roleMap.get(rolerid);
		return role;
	}
	
	private void loadRoleMap() {
		List<Role> roles = userDAO.selectAllRole();
		roleMap = new HashMap<>();
		for (Role role : roles) {
			roleMap.put(role.getRoleid(), role);
		}
	}
	
}
