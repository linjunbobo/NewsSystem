package com.chinasofiti.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
	protected Map<String, Object> returnAjax(String status, String message) {
		 Map<String, Object> rs=new  HashMap<String, Object>();
		 rs.put("msg",message);
		 rs.put("status",status);
		
		return rs;
		
		
	}

}
