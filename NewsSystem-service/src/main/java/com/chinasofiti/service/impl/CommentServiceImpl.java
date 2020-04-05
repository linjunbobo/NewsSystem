package com.chinasofiti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Comments;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.mapper.AutorMapper;
import com.chinasofiti.mapper.CommentMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICommentService;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IsysService;

import tk.mybatis.mapper.common.Mapper;
@Service
public  class CommentServiceImpl extends CommonServiceImpl<Comments>  implements ICommentService {

	@Autowired
	private CommentMapper Comments;

	@Override
	protected Mapper getMapper() {
		// TODO Auto-generated method stub
		return this.Comments;
	}
	

	@Override
	public List<com.chinasofiti.beans.Comments> findbycomment(String nid) {
		// TODO Auto-generated method stub
		return Comments.findbycomment(nid);}


	@Override
	public void updatezancout(String cid, int zan_count1) {
		// TODO Auto-generated method stub
		Comments.updatezancout(cid,zan_count1);
	}


	@Override
	public List<com.chinasofiti.beans.Comments> getcomment(Integer mid) {
		// TODO Auto-generated method stub
		return Comments.getcomment(mid);
	}


	@Override
	public int gettotal(com.chinasofiti.beans.Comments com) {
		// TODO Auto-generated method stub
		return Comments.selectCount(com);
	}


	@Override
	public void updateby(Integer checkid, String cid, String reason, Integer type) {
		// TODO Auto-generated method stub
		Comments.updateby(checkid,cid,reason,type);
	}




	









	

	
	
	}

	
	

	


