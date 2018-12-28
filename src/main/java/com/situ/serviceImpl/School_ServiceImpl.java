package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.School;
import com.situ.mapper.School_Mapper;
import com.situ.service.School_Service;
import com.situ.utils.SearchInfo;

@Service
public class School_ServiceImpl implements School_Service {
	@Autowired
	School_Mapper smapper;

	@Override
	public List<School> select(SearchInfo info) {
		return smapper.select(info);
	}

	@Override
	public void insert(School s) {
		smapper.insert(s);
	}

	@Override
	public void delete(int id) {
		smapper.delete(id);
	}

	@Override
	public void update(School s) {
		smapper.update(s);
	}

	@Override
	public School getbyid(int id) {
		return smapper.getbyid(id);
	}

	@Override
	public int getcount(SearchInfo info) {
		return smapper.getcount(info);
	}

	@Override
	public List<School> selectall() {
		return smapper.selectall();
	}

}
