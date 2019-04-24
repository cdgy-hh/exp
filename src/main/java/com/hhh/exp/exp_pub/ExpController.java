package com.hhh.exp.exp_pub;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hhh.exp.user.UserController;

@RestController
@RequestMapping("/exp/")
public class ExpController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private ExpService expservice;
	
	@RequestMapping("exp_pub")
	public JSONObject AllExp(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			List<Exp_pub> exp_pub=expservice.AllExp();
			response.put("data", exp_pub);
			response.put("code", 2);
		}catch(Exception e) {
			e.printStackTrace();
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("addexp") 
	public JSONObject AddOnlineExp(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject request=JSON.parseObject(reqstr);
			int typeid=request.getIntValue("typeid");
			String title=request.getString("title");
			String content=request.getString("content");
			int pubid=request.getIntValue("pubid");
			String pub_time=format.format(new Date());
			String end_time=request.getString("end_time");
			String status=request.getString("status");
			String url=request.getString("url");
			int num=request.getIntValue("num");
			Exp_pub exp=new Exp_pub(0,typeid,title,content,pubid,pub_time,end_time,status,url,num);
			int res=expservice.AddExp(exp);
			if(res>0) {
				response.put("code", 2);
			}else {
				response.put("code", 5);
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("updateexp")
	public JSONObject UpdateOnlineExp(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject request=JSON.parseObject(reqstr);
			int expid=request.getIntValue("expid");
			int typeid=request.getIntValue("typeid");
			String title=request.getString("title");
			String content=request.getString("content");
			int pubid=request.getIntValue("pubid");
			String pub_time=request.getString("pub_time");
			String end_time=request.getString("end_time");
			String status=request.getString("status");
			String url=request.getString("url");
			int num=request.getIntValue("num");
			Exp_pub exp=new Exp_pub(expid,typeid,title,content,pubid,pub_time,end_time,status,url,num);
			int res=expservice.UpdateExp(exp);
			if(res>0) {
				response.put("code", 2);
			}else {
				response.put("code", 5);
			}
		}catch(Exception e) {
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	@RequestMapping("deleteexp")
	public JSONObject DeleteExp(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject request=JSON.parseObject(reqstr);
			int expid=request.getIntValue("expid");
			int res=expservice.DeleteExp(expid);
			if(res>0) {
				response.put("code", 2);
			}else {
				response.put("code", 5);
			}
			}catch(Exception e) {
				e.printStackTrace();
				response.put("code", 5);
				response.put("msg", e.getMessage());
		}
		return response;
	}
}
