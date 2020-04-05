package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Collect;
import com.chinasofiti.beans.Manager;

public interface ICollectService extends ICommonService<Collect> {

	Collect findcollect(String nid, int mid);

	void removeby(String nid, int mid);

	List<Collect> getcollect(Integer mid);

}
