package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Comments;
import com.chinasofiti.beans.Manager;

public interface ICommentService extends ICommonService<Comments> {

	List<Comments> findbycomment(String nid);

	void updatezancout(String cid, int zan_count1);

	List<Comments> getcomment(Integer mid);

	int gettotal(Comments com);

	void updateby(Integer checker, String cid, String reason, Integer type);

}
