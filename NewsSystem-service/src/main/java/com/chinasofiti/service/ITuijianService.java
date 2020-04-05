package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Tuijian;

public interface ITuijianService extends ICommonService<Tuijian> {

	List<Tuijian> gettuijiannews(Integer mid);

}
