package com.situ.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.College;
import com.situ.mapper.College_Mapper;
import com.situ.service.College_Service;
import com.situ.utils.SearchInfo;
@Service
public class College_ServiceImpl implements College_Service {
	@Autowired
	College_Mapper cmapper;
	

	@Override
	public List<College> select(SearchInfo info) {
		return cmapper.select(info);
	}

	@Override
	public void insert(College c) {
		cmapper.insert(c);
	}

	@Override
	public void delete(int id) {
		cmapper.delete(id);
	}

	@Override
	public void update(College c) {
		cmapper.update(c);
	}

	@Override
	public College getbyid(int id) {
		return cmapper.getbyid(id);
	}

	@Override
	public int getcount(SearchInfo info) {
		return cmapper.getcount(info);
	}

	@Override
	public List<College> selectBySchool(int school_id) {
		return cmapper.selectBySchool(school_id);
	}

	

}
