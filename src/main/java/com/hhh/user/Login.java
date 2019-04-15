package com.hhh.user;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/login/")
public class Login {
	private static final Logger log = LoggerFactory.getLogger(Login.class);
	@RequestMapping("admin")
	public String adminlogin(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject return_data=new JSONObject();
		JSONObject response=new JSONObject();
		try {
			JSONObject requst=JSONObject.parseObject(reqstr);
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
