package com.chinasofiti.beans;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Comments {
	@Id
	private String cid; //菜单ID
	private String ccontent; 
	private String nid; 
	private String mid; 
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp time; 
	private Integer zan_count; 
	private Integer type; 
	private String checkid; 
	private String reason; 
	
	
	
	@Transient
	private Manager manager; 
	
	@Transient
	private New news; 

	

}
