package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Zan_count;

public interface IZan_countService extends ICommonService<Zan_count> {

	void deletcby(String cid, Integer mid);

	List<Zan_count> findzan(String nid, Integer mid);

}
