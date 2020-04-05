package com.chinasofiti.service.impl;

import java.util.List;

import com.chinasofiti.beans.New;
import com.chinasofiti.service.ICommonService;

import tk.mybatis.mapper.common.Mapper;

public abstract class CommonServiceImpl<T> implements ICommonService<T> {
	// 获取Mapper对象
	protected abstract Mapper getMapper();
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getMapper().selectAll();
	}

	@Override
	public List<T> findBy(T t) {
		// TODO Auto-generated method stub
		return  getMapper().select(t);
	}
	@Override
	public T findALLByid(String id) {
		// TODO Auto-generated method stub
		return  (T) getMapper().selectByPrimaryKey(id);
	}

	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		getMapper().insertSelective(t);
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getMapper().updateByPrimaryKeySelective(t);
		
	}

	@Override
	public void remove(T t) {
		// TODO Auto-generated method stub
		
		getMapper().delete(t);
	}
	public List<New> gettuijian(String s) {
		// TODO Auto-generated method stub
		return null;
	}

}
