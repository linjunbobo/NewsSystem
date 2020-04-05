package com.chinasofiti.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Video;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.IManagerService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IVideoService;
import com.chinasofiti.service.IsysService;

@Controller
@RequestMapping("/video")

public class VideoController extends BaseController {
	@Autowired
	private IVideoService videoService;
	
	
	//查询视频
	@RequestMapping(path = "/getVideo",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Video> findautor() {
			
		
		return videoService.getvideo();

			
		}

	
	}

	

