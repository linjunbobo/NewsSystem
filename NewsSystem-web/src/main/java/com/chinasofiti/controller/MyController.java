package com.chinasofiti.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofiti.beans.Collect;
import com.chinasofiti.beans.Comments;
import com.chinasofiti.beans.History;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.service.ICollectService;
import com.chinasofiti.service.ICommentService;
import com.chinasofiti.service.IHistoryService;
import com.chinasofiti.service.IManagerService;
import com.chinasofiti.service.INewcheckService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.impl.ManagerServiceImpl;
import com.github.pagehelper.PageHelper;
//import com.wxapi.WxApiCall.WxApiCall;
//import com.wxapi.model.RequestModel;

@Controller
@RequestMapping("/my")
public class MyController extends BaseController{
	@Autowired
	private IManagerService managerService;
	@Autowired
	private INewsService newService;
	@Autowired
	private ICollectService collectService;
	@Autowired
	private ICommentService commentService;
	@Autowired
	private IHistoryService historyService;
	
	//个人信息页
	@RequestMapping(path = "/getmanager",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Manager getmanager(HttpSession session) {
		
		Manager manager = (Manager)session.getAttribute("manager");
		if(manager==null) {
			return null;	
		}else {

			return manager;	
		}
		
	
	}
	
	//根据用户获取收藏
	@RequestMapping(path = "/getcollect",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Collect> getcollect(HttpSession session) {
		
		Manager manager = (Manager)session.getAttribute("manager");
		Integer mid=null;
		if(manager!=null) {	
			 mid = manager.getMid();}
	
	
	
		return 	collectService.getcollect(mid);
	}
	
	//退出登录
	@RequestMapping(path = "/logout",produces = {"application/json;charset=utf-8"})
	@ResponseBody
		public Map<String, Object> logout(HttpSession session) {

			session.removeAttribute("manager");
			return  returnAjax("success", "chengg");



		}
	//查询用户评论
	@RequestMapping(path = "/getcomment",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public 	List<Comments> getcomment(HttpSession session) {
		Manager manager = (Manager)session.getAttribute("manager");
		Integer mid = manager.getMid();
	List<Comments>	comments=commentService.getcomment(mid);
		return comments;
	
	}
	
	//查询用户浏览记录
	@RequestMapping(path = "/gethistory",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public 	List<History> gethistory(HttpSession session) {
		Manager manager = (Manager)session.getAttribute("manager");
		Integer mid = manager.getMid();
		
		List<History>	history=historyService.getHistory(mid);
		return history;
		
	
	
	}

}
