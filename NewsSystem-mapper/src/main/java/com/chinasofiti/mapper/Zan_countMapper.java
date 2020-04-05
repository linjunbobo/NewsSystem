package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Zan_count;
@Repository
public interface Zan_countMapper extends tk.mybatis.mapper.common.Mapper<Zan_count> {
	@Delete("DELETE  FROM zan_count WHERE cid=#{cid} AND MID=#{mid}")
	void deletcby(@Param(value = "cid") String cid,@Param(value = "mid") Integer mid);
	
	@Select("select * from zan_count where nid=#{nid} and mid=#{mid}")
	List<Zan_count> findzan(@Param(value = "nid") String nid, @Param(value = "mid")Integer mid);
	


	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
