package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Manager;

public interface IManagerService extends ICommonService<Manager> {

	List<Manager> findManager(Manager manger);
	int gettitle(Manager manager);
	Manager findALLByKeyid(Integer mid);

}
