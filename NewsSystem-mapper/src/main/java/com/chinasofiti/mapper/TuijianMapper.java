package com.chinasofiti.mapper;

import java.util.List;

import javax.persistence.Column;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Collect;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Tuijian;
@Repository
public interface TuijianMapper extends tk.mybatis.mapper.common.Mapper<Tuijian> {

	
	@Select("select * from tuijian where mid=#{mid} AND state=0 order by time desc limit 0,5")
	@Results({
			
			@Result(property="tid" ,column="tid"),
			@Result(property="mid" ,column="mid"),
			@Result(property="nid" ,column="nid"),
			@Result(property="time" ,column="time"),
			@Result(property="news" ,column="nid",one=@One(select="com.chinasofiti.mapper.NewMapper.findbynid"	))})
	List<Tuijian> gettuijiannews(Integer mid);


}
