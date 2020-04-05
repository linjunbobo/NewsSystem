package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Manager;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.service.IManagerService;
import com.mysql.jdbc.StringUtils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class ManagerServiceImpl extends CommonServiceImpl<Manager> implements IManagerService  {
	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	protected Mapper getMapper() {
		// TODO Auto-generated method stub
		return this.managerMapper;
	}
	@Override
	public List<Manager> findManager(Manager manager) {
		
		
		Example ex =new Example(Manager.class);
		//设置模糊查询条件
		Criteria c = ex.createCriteria();
		if(!StringUtils.isNullOrEmpty(manager.getAccount())) {
			c.andLike("account", "%"+manager.getAccount()+"%");
		}
		if(!StringUtils.isNullOrEmpty(manager.getMname())) {
			c.andLike("mname", "%"+manager.getMname()+"%");
		}
	
		//设置排序
		//ex.setOrderByClause("mid DESC");
		return 	managerMapper.selectByExample(ex);
		
	}
	@Override
	public int gettitle(Manager manager) {
		Example ex =new Example(Manager.class);
		//设置模糊查询条件
		Criteria c = ex.createCriteria();
		if(!StringUtils.isNullOrEmpty(manager.getAccount())) {
			c.andLike("account", "%"+manager.getAccount()+"%");
		}
		if(!StringUtils.isNullOrEmpty(manager.getMname())) {
			c.andLike("mname", "%"+manager.getMname()+"%");
		}
	
		//设置排序
		//ex.setOrderByClause("mid DESC");
		return 	managerMapper.selectCountByExample(ex);
		
	}
	@Override
	public Manager findALLByKeyid(Integer mid) {
		// TODO Auto-generated method stub
		return managerMapper.selectByPrimaryKey(mid);
	}
	

}
