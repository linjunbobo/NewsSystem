package com.chinasofiti.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data
public class Notice {
	@Id
	private Integer n_id; //菜单ID
	private Integer mid; 
	private String notice;
	
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Timestamp time; 

	@Transient
	private Manager manager;

}
