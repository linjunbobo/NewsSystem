package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
@Repository
public interface MenuMapper extends tk.mybatis.mapper.common.Mapper<Menu> {
	@Select("select *from menu where pid=#{string}")
	List<Menu> getMenuByPid(String string);
	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
