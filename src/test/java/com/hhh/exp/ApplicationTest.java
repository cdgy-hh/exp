package com.hhh.exp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hhh.exp.Application;
import com.hhh.exp.exp_pub.ExpService;
import com.hhh.exp.exp_pub.Exp_pub;
import com.hhh.exp.user.User;
import com.hhh.exp.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringApplicationConfiguration(classes = Application.class) 
@WebAppConfiguration 
public class ApplicationTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ExpService expservice;
	
    @Test
    public void listDataDetail() {
    	//userid,no,name,sex,phone,password,roleid,null
    	User user=new User();
    	user.setName("hh");
    	user.setNo(2);
    	user.setSex("女");
    	user.setPhone("19878546487");
    	user.setPassword("123456");
    	user.setRoleid(1);
    	userService.insertUser(user);
    }
	
    @Test
    public void deleteUserTest() {
    	userService.deleteUser(4);
    }
    
   /* @Test
    public void AddOnlineExpTest() {
    	Exp_pub exp=new Exp_pub();
    	exp.setContent("nihao");
    	exp.setEnd_time("2018-09-01");
    	exp.setEnd_time("2019-08-01");
    	exp.setExp_status("nan");
    	exp.setExpid(3);
    	exp.setTypeid(0);
    	exp.setTitle("hello");
    	exp.setPubid(2);
    	exp.setUrl(null);
    	exp.setNum(0);
    	expservice.AddExp(exp);
    }
    */
	@Test
	public void AllExpTest() {
		List<Exp_pub> exp_pub=expservice.AllExp();
	}
	
	/*@Test
	public void UpdateExpTest() {
		Exp_pub exp=new Exp_pub();
    	exp.setContent("nihao");
    	exp.setPub_time("2018-09-01");
    	exp.setEnd_time("2019-08-01");
    	exp.setStatus("nan");
    	exp.setExpid(3);
    	exp.setTypeid(0);
    	exp.setTitle("allen");
    	exp.setPubid(2);
    	exp.setUrl(null);
    	exp.setNum(0);
    	expservice.UpdateExp(exp);
	}*/
	
	@Test
	public void DeleteExpTest() {
		expservice.DeleteExp(1);
	}
}
