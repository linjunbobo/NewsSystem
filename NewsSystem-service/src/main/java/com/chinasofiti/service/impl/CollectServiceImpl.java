package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Collect;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.mapper.AutorMapper;
import com.chinasofiti.mapper.CollectMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICollectService;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class CollectServiceImpl extends CommonServiceImpl<Collect> implements ICollectService {

	@Autowired
	private CollectMapper collectMapper;

	@Override
	protected Mapper getMapper() {
		
		// TODO Auto-generated method stub
		return this.collectMapper;
	}

	@Override
	public Collect findcollect(String nid, int mid) {
		// TODO Auto-generated method stub
		return collectMapper.findcollect(nid,mid);
	}

	@Override
	public void removeby(String nid, int mid) {
		// TODO Auto-generated method stub
		collectMapper.removeby(nid,mid);
	}

	@Override
	public List<Collect> getcollect(Integer mid) {
		// TODO Auto-generated method stub
		Collect collect=new Collect();
		collect.setMid(mid);
		
		
		List<Collect> collects=collectMapper.getNewcollect(mid);
		
		return collects;
		
	}

	
	

	

}
