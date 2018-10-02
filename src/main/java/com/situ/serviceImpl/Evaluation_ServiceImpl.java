package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.Evaluation;
import com.situ.entity.Operator;
import com.situ.mapper.Evaluation_Mapper;
import com.situ.service.Evaluation_Service;
import com.situ.utils.EvaluationSearchInfo;
import com.situ.utils.SearchInfo;

@Service
public class Evaluation_ServiceImpl implements Evaluation_Service {

	@Autowired
	Evaluation_Mapper edao;
	
	@Override
	public List<Evaluation> index(SearchInfo info) {
		return edao.index(info);
	}

	@Override
	public List<Evaluation> selectSize(SearchInfo info) {
		return edao.selectSize(info);
	}

	@Override
	public int delete(int id) {
		return edao.delete(id);
	}
	
	@Override
	public int insert(Evaluation n) {
		return edao.insert(n);
	}
	
	@Override
	public int update(Evaluation n) {
		return edao.update(n);
	}
	
	@Override
	public Evaluation getById(int id) {
		return edao.getById(id);
	}

	@Override
	public List<Activity> selectActivity() {
		return edao.selectActivity();
	}

	@Override
	public List<Operator> selectOperator() {
		return edao.selectOperator();
	}

	@Override
	public void locking(int id) {
		edao.locking(id);
	}

	@Override
	public void unlock(int id) {
		edao.unlock(id);
	}

	@Override
	public int batchScore(Evaluation e) {
		return edao.batchScore(e);
	}

	@Override
	public List<Activity> selectIds(EvaluationSearchInfo info) {
		return edao.selectIds(info);
	}

	@Override
	public Evaluation s_evaluation(EvaluationSearchInfo info) {
		return edao.s_evaluation(info);
	}

	
}
