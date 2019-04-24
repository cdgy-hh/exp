package com.hhh.exp.exp_pub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpService {
	
	@Autowired
	ExpDao expdao;
	
	public List<Exp_pub> AllExp(){
		List<Exp_pub> res=new ArrayList<>();
		List<Exp_pub> temp=expdao.AllExp();
		for(Exp_pub exp:temp) {
			res.add(exp);
		}
		return res;
	}
	
	public int AddExp(Exp_pub exp) {
		int res=expdao.AddExp(exp);
		return res;
	}
	
	public int UpdateExp(Exp_pub exp) {
		int res=expdao.UpdateExp(exp);
		return res;
	}
	
	public int DeleteExp(int expid) {
		int res=expdao.DeleteExp(expid);
		return res;
	}
}
