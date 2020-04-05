package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Zan_count;
import com.chinasofiti.mapper.AutorMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.mapper.Zan_countMapper;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IZan_countService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class Zan_countServiceImpl extends CommonServiceImpl<Zan_count> implements IZan_countService {

	@Autowired
	private Zan_countMapper zan_countMapper;

	@Override
	protected Mapper getMapper() {
		
		// TODO Auto-generated method stub
		return this.zan_countMapper;
	}

	@Override
	public void deletcby(String cid, Integer mid) {
		// TODO Auto-generated method stub
		zan_countMapper.deletcby(cid,mid);
	}

	@Override
	public List<Zan_count> findzan(String nid, Integer mid) {
		// TODO Auto-generated method stub
		return zan_countMapper.findzan(nid,mid);
	}

	
	

	

}
