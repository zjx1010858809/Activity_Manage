package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.Notice;
import com.situ.entity.Operator;
import com.situ.mapper.Notice_Mapper;
import com.situ.service.Notice_Service;
import com.situ.utils.SearchInfo;

@Service
public class Notice_ServiceImpl implements Notice_Service {

	@Autowired
	Notice_Mapper ndao;
	
	@Override
	public List<Notice> select(SearchInfo info) {
		return ndao.select(info);
	}

	@Override
	public List<Notice> selectSize(SearchInfo info) {
		return ndao.selectSize(info);
	}

	@Override
	public int delete(int id) {
		return ndao.delete(id);
	}
	
	@Override
	public int insert(Notice n) {
		return ndao.insert(n);
	}
	
	@Override
	public int update(Notice n) {
		return ndao.update(n);
	}
	
	@Override
	public Notice getById(int id) {
		return ndao.getById(id);
	}

	@Override
	public List<Activity> selectActivity() {
		return ndao.selectActivity();
	}

	@Override
	public List<Operator> selectOperator() {
		return ndao.selectOperator();
	}

	
}
