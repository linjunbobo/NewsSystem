package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Manager;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class sysServiceImpl extends CommonServiceImpl<Manager> implements IsysService {

	@Autowired
	private ManagerMapper managerMapper;

	@Override
	protected Mapper getMapper() {
		// TODO Auto-generated method stub
		return this.managerMapper;
	}
	

	

}
