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
import com.chinasofiti.beans.Notice;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.IManagerService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.INoticeService;
import com.chinasofiti.service.IsysService;

@Controller
@RequestMapping("/notice")

public class NoticeController extends BaseController {
	@Autowired
	private INoticeService NoticeService;
	
	@RequestMapping(path = "/getnotice",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Notice> getnotice() {
		
		
		return NoticeService.getfistnotice();

			
		}
	
	//添加公告牌
	@RequestMapping(path = "/addnotice",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> addnotice( Notice notice,HttpSession session) {
		Manager manager=(Manager)session.getAttribute("manager");
		if(manager==null) {
			return  returnAjax("failure", "添加失败");
		}
		
		notice.setMid(manager.getMid());
		NoticeService.addnotice(notice);
		
		return  returnAjax("success", "添加成功");

			
		}
	
	//删除公告牌
	@RequestMapping(path = "/removenotice",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> removenotice(String n_id,HttpSession session) {
	
		
		
		NoticeService.removekey(n_id);
		
		return  returnAjax("success", "添加成功");

			
		}

	
	}

	

