package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Manager;
@Repository
public interface ManagerMapper extends tk.mybatis.mapper.common.Mapper<Manager> {
	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */
	 @Select("select * from manager where mid=#{mid}")
	 List<Manager> findByid(Integer mid);

}
