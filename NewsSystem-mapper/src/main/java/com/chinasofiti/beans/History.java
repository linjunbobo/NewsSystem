package com.chinasofiti.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class History {
	@Id
	private Integer h_id; //菜单ID
	private Integer mid; 
	private Integer nid; 
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp time; 
	private Integer count; 
	@Transient
	private New news; 

}
