package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.beans.New;

public interface INewsService extends ICommonService<New> {

	Category findtypebyid(Integer typeid);

	int findtolal(New news);


	void updatebykey(Integer usernameid, String nid, String reason, Integer state);

	List<New> findBytitle(New news,int page , int rows );

	void gettuijian(Integer mid, String nid);

	




}
