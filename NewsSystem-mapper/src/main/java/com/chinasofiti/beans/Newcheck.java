package com.chinasofiti.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data

public class Newcheck {
	@Id
	private Integer cid; //新闻ID
	private Integer nid; //题目名称
	private Integer state; //菜单图标
	private String reason; //菜单URL
	private Integer checknameid; //来源



}
