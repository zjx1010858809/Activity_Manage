package com.situ.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.entity.Login;
import com.situ.mapper.login_mapper;
import com.situ.service.login_service;

@Service
public class login_serviceImpl implements login_service{
	
	@Autowired
	login_mapper ldao;

	@Override
	public Login userLogin(Login log) {
		return ldao.userLogin(log);
	}

	@Override
	public Login operLogin(Login log) {
		return ldao.operLogin(log);
	}

}
