package com.chinasofiti.service;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

public interface ICommonService<T> {
	

	/*
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	/**
	 * 根据id查询
	 * @param 
	 * @return
	 */
	
	List<T> findBy(T t);
	
	
	T findALLByid(String t);
	
	/**
	 * 添加
	 * @param t
	 */
	void add(T t);
	
	
	/**
	 * 更新
	 * @param t
	 */
	void update(T t);
	/**
	 
	 *删除 
	 * @param t
	 */
	void  remove(T t);
	
	

}
