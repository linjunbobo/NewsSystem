package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Notice;
import com.chinasofiti.mapper.AutorMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.mapper.NoticeMapper;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.INoticeService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class NoticeServiceImpl extends CommonServiceImpl<Notice> implements INoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	protected Mapper getMapper() {
		
		// TODO Auto-generated method stub
		return this.noticeMapper;
	}

	@Override
	public List<Notice> getfistnotice() {
		// TODO Auto-generated method stub
		return noticeMapper.getfistnotice();
	}

	@Override
	public void addnotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.insertSelective(notice);
	}

	@Override
	public void removekey(String n_id) {
		// TODO Auto-generated method stub
		noticeMapper.deleteByPrimaryKey(Integer.parseInt(n_id) );
	}

	
	

	

}
