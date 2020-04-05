package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Notice;
@Repository
public interface NoticeMapper extends tk.mybatis.mapper.common.Mapper<Notice> {
	@Select("select * from  notice  order by time desc ")
	@Results({
		@Result(property="n_id" ,column="n_id"),
		@Result(property="mid" ,column="mid"),
		@Result(property="notice" ,column="notice"),
		@Result(property="time" ,column="time"),
	
		@Result(property="manager" ,column="mid",one=@One(select="com.chinasofiti.mapper.ManagerMapper.findByid"))
		
		})
			
			
			
	List<Notice> getfistnotice();
	


	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
