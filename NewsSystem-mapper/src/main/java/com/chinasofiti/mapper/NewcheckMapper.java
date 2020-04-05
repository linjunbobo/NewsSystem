package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Newcheck;
@Repository
public interface NewcheckMapper extends tk.mybatis.mapper.common.Mapper<Newcheck> {
	@Select("select * from Newcheck where nid=#{nid}")
	List<Newcheck> findByNid(String nid);
	


	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
