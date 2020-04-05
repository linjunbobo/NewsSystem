package com.chinasofiti.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.History;
import com.chinasofiti.beans.Manager;

public interface IHistoryService extends ICommonService<History> {

	void addhistory(String nid, HttpSession session);

	List<History> getHistory(Integer mid);

}
