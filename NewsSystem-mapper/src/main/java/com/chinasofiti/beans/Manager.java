package com.chinasofiti.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;


@Data
public class Manager {
	@Id
	private  Integer mid;
	private String account;
	private String password;
	private String mname;
	private Integer type;
	private Integer sex;
	private String email;
	private String img;
	private Date birthday;
	//取消数据库映射
	@Transient
	private List<Comments> comments;
	


	
	
	
	
	

}
