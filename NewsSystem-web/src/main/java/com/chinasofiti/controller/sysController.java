package com.chinasofiti.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chinasofiti.beans.Manager;
import com.chinasofiti.service.IManagerService;
import com.chinasofiti.service.IsysService;

@Controller
@RequestMapping("/sys")

public class sysController extends BaseController {
	@Autowired
	private IsysService sysservice;
	
	@RequestMapping(path = "/findManageByid",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> findlogin(String account,String  password,HttpSession session) {
		Manager manager=new Manager();
		manager.setAccount(account);
		manager.setPassword(password);
	
		List<Manager> username = sysservice.findBy(manager);
	
		if (username == null || username.size() == 0) {
			return returnAjax("failure", "用户名或密码不正确");
		} else {
			// 保存用户的登录状态
		 session.setAttribute("manager", username.get(0));
			if(username.get(0).getType()==0) {
				return returnAjax("success", "登录成功");
			}else
			{
				return returnAjax("success", "管理员你好");
			}
			
		}

		
	}
	
	//shiro测试
	@RequestMapping(path = "/loginmanger",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> loginmanger(Manager manager,Model model) {
		
		//创建令牌
		UsernamePasswordToken  	token =new UsernamePasswordToken(manager.getAccount(),manager.getMname());
		//获取Subject对象，该对象封装了一系列的操作
		Subject subject =SecurityUtils.getSubject();
		//认证
		try {
			subject.login(token);
			return returnAjax("success", "登录成功");
			
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			return returnAjax("failure", "用户名或密码不正确");
		}
		
		
		/*
		 * List<Manager> username = sysservice.findBy(manager);
		 * System.out.println(username); if (username == null || username.size() == 0) {
		 * 
		 * } else { // 保存用户的登录状态 model.addAttribute("manager",username.get(0));
		 * 
		 * if(username.get(0).getType()==0) { return returnAjax("success", "登录成功");
		 * }else { return returnAjax("success", "管理员你好"); }
		 * 
		 * }
		 */

		
	}

	

	
}
