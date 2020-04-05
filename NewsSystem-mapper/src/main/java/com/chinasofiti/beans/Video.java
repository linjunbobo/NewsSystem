package com.chinasofiti.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Video {
	@Id
	private Integer vid; //菜单ID
	private Integer mid; 
	private String src; 
	private String title; 
	private Integer type; 
	 @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone="GMT+8")
	private Timestamp  time	; 
	private Integer zan_count; 
	private Integer history; 
	private  Integer state; 
	private String reason; 
	private String usernameid; 
	
	@Transient
	private Manager manager;


}
