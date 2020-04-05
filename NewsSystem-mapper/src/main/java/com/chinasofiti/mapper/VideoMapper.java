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
import com.chinasofiti.beans.Video;
@Repository
public interface VideoMapper extends tk.mybatis.mapper.common.Mapper<Video> {
	 @Select("SELECT * FROM video v ,manager m WHERE v.mid=m.`mid` AND state=1")
	 @Results({
			@Result(property="vid" ,column="vid"),
			@Result(property="mid" ,column="mid"),
			@Result(property="src" ,column="src"),
			@Result(property="title" ,column="title"),
			@Result(property="type" ,column="type"),
			@Result(property="zan_count" ,column="zan_count"),
			@Result(property ="history" , column="history"),
			@Result(property ="state" , column="state"),
			@Result(property="manager" ,column="mid",one=@One(select="com.chinasofiti.mapper.ManagerMapper.findByid"	))
			
			})
	 List<Video> getvideo();
	 


	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
