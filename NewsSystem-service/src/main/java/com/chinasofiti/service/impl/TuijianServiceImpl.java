package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Tuijian;
import com.chinasofiti.mapper.AutorMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.mapper.TuijianMapper;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.ITuijianService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class TuijianServiceImpl extends CommonServiceImpl<Tuijian> implements ITuijianService {

	@Autowired
	private TuijianMapper TuijianMapper;

	@Override
	protected Mapper getMapper() {
		
		// TODO Auto-generated method stub
		return this.TuijianMapper;
	}

	@Override
	public List<Tuijian> gettuijiannews(Integer mid) {
		// TODO Auto-generated method stub
		return TuijianMapper.gettuijiannews(mid);
	}

	
	

	

}
