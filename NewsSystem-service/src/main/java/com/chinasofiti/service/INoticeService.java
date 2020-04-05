package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Notice;

public interface INoticeService extends ICommonService<Notice> {

	List<Notice> getfistnotice();

	void addnotice(Notice notice);

	void removekey(String n_id);

}
