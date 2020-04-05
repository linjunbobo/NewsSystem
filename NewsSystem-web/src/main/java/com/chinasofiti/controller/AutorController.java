package com.chinasofiti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.IManagerService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IsysService;

@Controller
@RequestMapping("/autor")

public class AutorController extends BaseController {
	@Autowired
	private IAutorService autorService;
	
	@RequestMapping(path = "/findautor",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public List<Autor> findautor(String aid) {
			Autor autor =new Autor();
			autor.setAid(aid);
		
		
		return autorService.findBy(autor);

			
		}

	@RequestMapping(path = "/test",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public Map<String, Object> test(String aid) {
			
		System.out.println("nihaodeya");
		
		return returnAjax("success", "shdasdsa");

			
		}


	
	}


	

