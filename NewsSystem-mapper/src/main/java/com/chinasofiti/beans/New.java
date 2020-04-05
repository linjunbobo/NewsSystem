package com.chinasofiti.beans;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Table(name="news")
public class New {
	@Id
	private String nid; //新闻ID
	private String title; //题目名称
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp time; //菜单图标
	private String pic; //菜单URL
	private String src; //来源
	private Integer type; //上
	private String content; //新闻内容
	private Integer state; //上
	private String reason;
	private Integer usernameid;
	private Integer autor;


}
