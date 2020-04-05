package com.chinasofiti.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.wxapi.WxApiCall.WxApiCall;
import com.wxapi.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.service.IManagerService;
import com.chinasofiti.service.INewcheckService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.impl.ManagerServiceImpl;
import com.github.pagehelper.PageHelper;
//import com.wxapi.WxApiCall.WxApiCall;
//import com.wxapi.model.RequestModel;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController{
	@Autowired
	private IManagerService managerService;
	@Autowired
	private INewsService newService;
	
	//分页查找所有用户找用户
	@RequestMapping(path = "/findManager",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public  Map<String,Object> findManger(Manager manger,int rows,int page) {
		// 加入分页条件
		
		//System.out.println("row="+rows);
		Map<String, Object> map =new HashMap<String, Object>();
		PageHelper.startPage(page, rows);
		List<Manager> findManager = managerService.findManager(manger);
		System.out.println("findManager="+findManager);
		//System.out.println(manger);
		int total =managerService.gettitle(manger);
		map.put("total", total);
		map.put("rows", findManager);
	
		
	
		return map;	
	}
	
	//根据mid查找用户
	@RequestMapping(path = "/finManagerBymid",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Manager> finManagerBymid(Manager manager) {
		
		
		return managerService.findBy(manager);
		//System.out.println(manager);
		
	
		
	}
	
	@RequestMapping(path = "/addManager",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> addmanager(Manager manager) {
		//System.out.println(manager);
		
		try {
			if(manager.getType()==null) {
				manager.setType(0);
			}
			if(manager.getMname()==null) {
				manager.setMname(manager.getAccount());
			}
			managerService.add(manager);
			return returnAjax("success", "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			return returnAjax("failuer", "添加失败");
		}
		
	}
	
	//更新
	@RequestMapping(path = "/updateManager",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> updatemanager(Manager manager,HttpSession session){
		
	
		try {
			
			managerService.update(manager);
			System.out.println("manager"+manager);
			Manager man = managerService.findALLByKeyid(manager.getMid());
			System.out.println("man"+man);
			session.setAttribute("manager", man);
			return returnAjax("success", "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return returnAjax("failuer", "修改失败");
		}

		
	}
	@RequestMapping(path = "/removeManager",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> removeManager(Manager manager){
		
		try {
			//System.out.println(manager);
			managerService.remove(manager);
			return returnAjax("success", "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return returnAjax("failuer", "添加失败");
		}

		
		
	}
	
	//获取登录信息
	@RequestMapping(path = "/getmanager",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Manager getmanager(HttpSession session){
		
		Manager manager=(Manager)session.getAttribute("manager");
		if(manager==null) {
			return null;
		}else {
			return manager;
		}
			
		
	}
	
	
	
	
	//添加新闻接口
	@RequestMapping(path = "/addnews",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public  Map<String, Object> addnews(New  json) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		New nes = newService.findALLByid("1");
		//System.out.println(json);
		double type1 = (Math.random()*14);
		int type=(int)Math.ceil(type1);
		json.setType(type);
		json.setState(0);
		newService.add(json);
		
		return returnAjax("success", "添加成功");
		
	}
	
	
	
	
	
	@RequestMapping(path = "/news",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public  String news(String num,String start) {

		RequestModel model = new RequestModel();
		model.setGwUrl("https://way.jd.com/jisuapi/get");
		model.setAppkey("87e8b6cfbf604fd83512d2ec1ce685d3");
		Map queryMap = new HashMap();
		queryMap.put("channel","头条"); //访问参数
		queryMap.put("num",num); //访问参数
		queryMap.put("start", start); //访问参数
		model.setQueryParams(queryMap);
		WxApiCall call = new WxApiCall();
		call.setModel(model);



		return call.request();
	}

}
