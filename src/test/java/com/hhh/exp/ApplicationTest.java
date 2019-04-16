package com.hhh.exp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hhh.exp.user.User;
import com.hhh.exp.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringApplicationConfiguration(classes = Application.class) 
@WebAppConfiguration 
public class ApplicationTest {
	
	@Autowired
	private UserService userService;
	
    @Test
    public void listDataDetail() {
    	//userid,no,name,sex,phone,password,roleid,null
    	User user=new User();
    	user.setName("小A");
    	user.setNo(2);
    	user.setSex("女");
    	user.setPhone("19878546487");
    	user.setPassword("123456");
    	user.setRoleid(1);
    	userService.insertUser(user);
    }
	
	
	
}
