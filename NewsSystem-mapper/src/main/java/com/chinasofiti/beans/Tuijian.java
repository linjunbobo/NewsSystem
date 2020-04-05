package com.chinasofiti.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Tuijian {
	@Id
	private Integer tid; //菜单ID
	private Integer nid; 
	private Integer mid; 
	@JsonFormat(pattern = ("yyyy-MM-dd HH:mm:ss" ),timezone = "GMT+8")
	private Timestamp time; 
	private Integer state; 
	
	@Transient
	private  New news;


}
