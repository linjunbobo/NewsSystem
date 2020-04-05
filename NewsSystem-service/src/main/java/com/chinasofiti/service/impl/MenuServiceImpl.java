package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.MenuMapper;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.IsysService;
import com.chinasofiti.service.MenuService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class MenuServiceImpl extends CommonServiceImpl<Menu> implements MenuService {

	@Autowired
	private MenuMapper mumpper;

	@Override
	protected Mapper getMapper() {
		// TODO Auto-generated method stub

		return this.mumpper;
	}

	@Override
	public Menu getTopMenu() {
		List<Menu> topid = mumpper.getMenuByPid("-1");
		Menu menu = topid.get(0);
		//获取一级
		List<Menu> menuList_1 = mumpper.getMenuByPid(menu.getMenuid());
		menu.setMenus(menuList_1);
		
		for (Menu menu2 : menuList_1) {
			
			List<Menu> menuList_2 = mumpper.getMenuByPid(menu2.getMenuid());
			menu2.setMenus(menuList_2);
		}
		return menu;
	}
	

	

}
