package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.mapper.AutorMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class AutorServiceImpl extends CommonServiceImpl<Autor> implements IAutorService {

	@Autowired
	private AutorMapper AutorMapper;

	@Override
	protected Mapper getMapper() {
		
		// TODO Auto-generated method stub
		return this.AutorMapper;
	}

	
	

	

}
