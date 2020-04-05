package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Newcheck;

public interface INewcheckService extends ICommonService<Newcheck> {

	List<Newcheck> findByNid(String nid);

}
