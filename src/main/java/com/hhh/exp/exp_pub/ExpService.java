package com.hhh.exp.exp_pub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpService {
	
	@Autowired
	ExpDao expdao;
	
	public List<Exp_pub> OnlineExp(){
		List<Exp_pub> res=new ArrayList<>();
		List<Exp_pub> temp=expdao.OnlineExp();
		for(Exp_pub exp:temp) {
			res.add(exp);
		}
		return res;
	}
	
	public int AddOnlineExp(Exp_pub exp) {
		int res=expdao.AddOnlineExp(exp);
		return res;
	}
	
	public int UpdateOnlineExp(int expid) {
		int res=expdao.UpdateOnlineExp(expid);
		return res;
	}
}
