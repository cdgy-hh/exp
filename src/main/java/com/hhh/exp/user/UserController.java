package com.hhh.exp.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;



@RestController
@RequestMapping("/user/")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("login")
	public JSONObject adminlogin(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject requst=JSONObject.parseObject(reqstr);
			String username = requst.getString("username");
			String password = requst.getString("password");
			System.out.println("username:"+username);
			System.out.println("password"+password);
			response.put("code",2);
		}catch (Exception e) {
			response.put("code",5);
			response.put("msg", e.getMessage());
		}
		
		return response;
	}
	

}
