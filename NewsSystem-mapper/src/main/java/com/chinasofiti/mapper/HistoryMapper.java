package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.History;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.beans.New;
@Repository
public interface HistoryMapper extends tk.mybatis.mapper.common.Mapper<History> {
	@Select("SELECT * FROM history h ,news n WHERE h.`nid`=n.`nid` AND h.`mid`=#{mid} ORDER BY h.count DESC")
	@Results({
		@Result(property="h_id" ,column="h_id"),
		@Result(property="mid" ,column="mid"),
		@Result(property="nid" ,column="nid"),
		@Result(property="time" ,column="time"),
		@Result(property="count" ,column="count"),
		@Result(property="news" ,column="nid",one=@One(select="com.chinasofiti.mapper.NewMapper.findbynid"	))
		
		})
	List<History> getHistory(Integer mid);

	
	@Select("select *from history where mid=#{mid} ORDER BY TIME DESC limit 0,5")
	List<History> selectBymid(int mid);
	


	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
