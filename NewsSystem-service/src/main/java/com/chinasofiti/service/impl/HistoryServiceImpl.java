package com.chinasofiti.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.History;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.mapper.AutorMapper;
import com.chinasofiti.mapper.HistoryMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.IHistoryService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class HistoryServiceImpl extends CommonServiceImpl<History> implements IHistoryService {

	@Autowired
	private HistoryMapper historyMapper;

	@Override
	protected Mapper getMapper() {
		
		// TODO Auto-generated method stub
		return this.historyMapper;
	}

	@Override
	public void addhistory(String nid, HttpSession session) {
		// TODO Auto-generated method stub
		History history =new History();
		  Manager manager = (Manager)session.getAttribute("manager");
		  Integer mid = manager.getMid();
		 Integer nids=Integer.parseInt(nid);
		 history.setMid(mid);
		 history.setNid(nids);
		List<History> historys= historyMapper.select(history);
		if(historys.size()==0) {
			history.setCount(1);
			historyMapper.insert(history);
		}else {
			historys.get(0).setCount(historys.get(0).getCount()+1);	
			historyMapper.updateByPrimaryKey(historys.get(0));
		}
	}

	@Override
	public List<History> getHistory(Integer mid) {
		// TODO Auto-generated method stub
		return historyMapper.getHistory(mid);
	}

	
	

	

}
