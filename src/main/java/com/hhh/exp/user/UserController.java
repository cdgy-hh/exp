package com.hhh.exp.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;



@RestController
@RequestMapping("/user/")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public JSONObject adminlogin(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject requst=JSONObject.parseObject(reqstr);
			String username = requst.getString("username");
			String password = requst.getString("password");
			User user = userService.getUserByName(username);
			if(user!=null) {
				if(password.equals(user.getPassword())) {
					response.put("code",2);
					response.put("user",user);
				}else {
					response.put("code",5);
					response.put("msg","密码错误");
				}
			}else {
				response.put("code",5);
				response.put("msg","该用户未注册");
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		
		return response;
	}
	

}