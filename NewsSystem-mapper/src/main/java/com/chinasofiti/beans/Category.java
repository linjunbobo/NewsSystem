package com.chinasofiti.beans;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
public class Category {
	@Id
	private String id; //菜单ID
	private String category; 


}
