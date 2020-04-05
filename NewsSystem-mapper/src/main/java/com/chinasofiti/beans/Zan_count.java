package com.chinasofiti.beans;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
public class Zan_count {
	@Id
	private Integer z_id; //菜单ID
	private Integer	 cid; 
	private Integer mid; 
	private Integer nid; 
	


}
