package com.chinasofiti.beans;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Data
public class Autor {
	@Id
	private String aid; //菜单ID
	private String abirthday; 
	private String aname; 
	private String aaddress; 


}
