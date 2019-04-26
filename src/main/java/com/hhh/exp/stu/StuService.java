package com.hhh.exp.stu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hhh.exp.exp_pub.ExpDao;
import com.hhh.exp.exp_pub.Exp_pub;

@Service
public class StuService {
	
	@Autowired
	StuDao studao;
	
	@Autowired
	ExpDao expdao;
	
	public JSONArray selectExpByStuid(int stuid,boolean chooseflag){
		JSONArray arr = new JSONArray();
		Map<Integer,Exp_stu> expMap = new HashMap<>();
		List<Exp_stu> temp=studao.StuExp(stuid);
		for (Exp_stu Exp_stu : temp) {
			expMap.put(Exp_stu.getExpid(),Exp_stu);
		}
		List<Exp_pub> exps = expdao.AllExp();
		for (Exp_pub exp_pub : exps) {
			JSONObject obj = new JSONObject();
			obj.put("expid", exp_pub.getExpid());
			obj.put("content", exp_pub.getContent());
			obj.put("end_time", exp_pub.getEnd_time());
			obj.put("pub_time", exp_pub.getPub_time());
			obj.put("title", exp_pub.getTitle());
			obj.put("status", expMap.get(exp_pub.getExpid())==null?true:false);
			if(!obj.getBooleanValue("status")) {
				Exp_stu exp_stu = expMap.get(exp_pub.getExpid());
				obj.put("rid", exp_stu.getId());
			}
			if(exp_pub.getTypeid()==2 && (obj.getBooleanValue("status")==chooseflag)) {
				arr.add(obj);
			}
		}
		return arr;
	}
	
	public int InsertExp(Exp_stu stu) {
		int res=studao.InsertExp(stu);
		return res;
	}
	
	public int CancelExp(int id) {
		int res=studao.CancelExp(id);
		return res;
	}
}
