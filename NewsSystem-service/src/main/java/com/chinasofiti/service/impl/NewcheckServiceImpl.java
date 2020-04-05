package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Newcheck;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.mapper.NewcheckMapper;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewcheckService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class NewcheckServiceImpl extends CommonServiceImpl<Newcheck> implements INewcheckService {

	@Autowired
	private NewcheckMapper newcheckMapper;

	@Override
	protected Mapper getMapper() {
		// TODO Auto-generated method stub
		return this.newcheckMapper;
	}

	@Override
	public List<Newcheck> findByNid(String nid) {
		// TODO Auto-generated method stub
		return newcheckMapper.findByNid(nid);
	}

	

	
	

	

}
