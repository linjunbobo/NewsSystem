package com.chinasofiti.service;

import java.util.List;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Video;

public interface IVideoService extends ICommonService<Video> {

	List<Video> getvideo();

}
