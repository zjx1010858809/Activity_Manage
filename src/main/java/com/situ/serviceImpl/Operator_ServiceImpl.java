package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Operator;
import com.situ.mapper.Operator_Mapper;
import com.situ.service.Operator_Service;
import com.situ.utils.SearchInfo;

@Service
public class Operator_ServiceImpl implements Operator_Service{
	
	@Autowired
	Operator_Mapper odao;
	
	public List<Operator> index(SearchInfo info) {
		return odao.index(info);
	}
	
	public List<Operator> selectSize(SearchInfo info) {
		return odao.selectSize(info);
	}


	public int insert(Operator o) {
		return odao.insert(o);
	}

	public void updatePass(int id) {
		odao.updatePass(id);
	}

	public void update(Operator oper) {
		odao.update(oper);
	}

	public Operator getById(int id) {
		return odao.getById(id);
	}

	public List<Operator> selectall() {
		return odao.selectall();
	}

}
