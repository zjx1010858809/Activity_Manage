package com.situ.service;

import java.util.List;

import com.situ.entity.Activity;
import com.situ.entity.Evaluation;
import com.situ.entity.Operator;
import com.situ.utils.CheckWorkSearchInfo;
import com.situ.utils.EvaluationSearchInfo;
import com.situ.utils.SearchInfo;

public interface Evaluation_Service {
	
	public List<Evaluation> selectsingle(CheckWorkSearchInfo info);
	
	public List<Evaluation> index(SearchInfo info);

	public List<Evaluation> selectSize(SearchInfo info);

	public int insert(Evaluation n);

	public int update(Evaluation n);
	
	public int batchScore(Evaluation e);
	
	public int delete(int id);

	public Evaluation getById(int id);
	
	public List<Activity> selectActivity();
	
	public List<Operator> selectOperator();
	
	public void locking(int id);
	
	public void unlock(int id);
	
	public List<Activity> selectIds(EvaluationSearchInfo info);
	
	public Evaluation s_evaluation(EvaluationSearchInfo info);

}
