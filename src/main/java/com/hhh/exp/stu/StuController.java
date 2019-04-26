package com.hhh.exp.stu;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("exp_stu")
public class StuController {
	private static final Logger log = LoggerFactory.getLogger(StuController.class);
	private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	StuService stuservice;
	
	@RequestMapping("stuexp")
	public JSONObject StuExp(@RequestParam int  stuid,@RequestParam boolean flag) {
		log.info("StuExp:stuid="+stuid);
		JSONObject response=new JSONObject();
		try {
			JSONArray stu=stuservice.selectExpByStuid(stuid,flag);
			response.put("data",stu);
			response.put("code", 2);
		}catch(Exception e) {
			e.printStackTrace();
			response.put("code", 5);
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	
	@RequestMapping("insertexp")
	public JSONObject InsertExp(@RequestBody String reqstr) {
		log.info(reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject request=JSON.parseObject(reqstr);
			int stuid=request.getIntValue("stuid");
			int expid=request.getIntValue("expid");
			String time=format.format(new Date());
			Exp_stu stu=new Exp_stu();
			stu.setStuid(stuid);
			stu.setExpid(expid);
			stu.setTime(time);
			int res=stuservice.InsertExp(stu);
			if(res>0) {
				response.put("code", 2);
			}else {
				response.put("code", 5);
			}
			}catch(Exception e) {
				e.printStackTrace();
				response.put("code", 5);
				response.put("msg", 5);
		}
		return response;
	}
	
	@RequestMapping("cancelexp")
	public JSONObject CancelExp(@RequestBody String reqstr) {
		log.info("cancelexp:"+reqstr);
		JSONObject response=new JSONObject();
		try {
			JSONObject request=JSON.parseObject(reqstr);
			int id=request.getIntValue("id");
			int res=stuservice.CancelExp(id);
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
