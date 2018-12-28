package com.situ.service;

import java.util.List;

import com.situ.entity.Checkwork;
import com.situ.utils.CheckWorkSearchInfo;

public interface CheckWork_Service {
	
	public List<Checkwork> selectDate(CheckWorkSearchInfo info);
	
	public List<Checkwork> select(CheckWorkSearchInfo info);
	
	public void insert(Checkwork c);
	
	public void delete(int id);
	
	public void update(Checkwork c);
	
	public Checkwork getbyid(int id);
	
	public int getcount(CheckWorkSearchInfo info);
	
	public void updatecheck(Checkwork c);
	
}
