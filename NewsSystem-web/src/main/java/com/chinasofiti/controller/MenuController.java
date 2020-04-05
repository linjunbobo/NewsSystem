package com.chinasofiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofiti.beans.Menu;
import com.chinasofiti.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menservice;
	
	@RequestMapping(path="/getData", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Menu getData() {
	
		return menservice.getTopMenu();
	}

}
