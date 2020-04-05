package com.chinasofiti.beans;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
public class Collect {
	@Id
	private Integer	 c_id; //菜单ID
	private Integer	 nid; 
	private Integer mid; 
	
	@Transient
	private New	 news;



}
