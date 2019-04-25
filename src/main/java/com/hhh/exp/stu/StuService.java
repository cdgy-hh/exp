package com.hhh.exp.stu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuService {
	
	@Autowired
	StuDao studao;
	
	public List<Exp_stu> StuExp(){
		List<Exp_stu> res=new ArrayList<>();
		List<Exp_stu> temp=studao.StuExp();
		for(Exp_stu stu:temp) {
			res.add(stu);
		}
		return res;
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
