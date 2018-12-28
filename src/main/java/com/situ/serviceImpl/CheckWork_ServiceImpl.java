package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Activity;
import com.situ.entity.Checkwork;
import com.situ.mapper.CheckWork_Mapper;
import com.situ.service.CheckWork_Service;
import com.situ.utils.CheckWorkSearchInfo;
@Service
public class CheckWork_ServiceImpl implements CheckWork_Service {
	@Autowired
	CheckWork_Mapper cmapper;

	@Override
	public List<Checkwork> select(CheckWorkSearchInfo info) {
		return cmapper.select(info);
	}

	@Override
	public void insert(Checkwork c) {
		cmapper.insert(c);
	}

	@Override
	public void delete(int id) {
		cmapper.delete(id);
	}

	@Override
	public void update(Checkwork c) {
		cmapper.update(c);
	}

	@Override
	public Checkwork getbyid(int id) {
		return cmapper.getbyid(id);
	}

	@Override
	public int getcount(CheckWorkSearchInfo info) {
		return cmapper.getcount(info);
	}

	@Override
	public List<Checkwork> selectDate(CheckWorkSearchInfo info) {
		return cmapper.selectDate(info);
	}

	@Override
	public void updatecheck(Checkwork c) {
		cmapper.updatecheck(c);
	}

}
