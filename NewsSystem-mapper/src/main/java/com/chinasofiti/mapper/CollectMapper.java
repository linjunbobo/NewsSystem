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
@Repository
public interface CollectMapper extends tk.mybatis.mapper.common.Mapper<Collect> {
	@Select("select * from collect where nid=#{nid} and mid=#{mid}")
	Collect findcollect(@Param(value = "nid") String nid,@Param(value = "mid") int mid);
	@Delete("DELETE  FROM collect WHERE nid=#{nid} AND MID=#{mid}")
	void removeby(@Param(value = "nid") String nid,@Param(value = "mid")  int mid);
	
	@Select("SELECT * FROM collect c ,news n WHERE c.`nid`=n.`nid` AND c.`mid`=#{mid}")
	@Results({
		@Result(property ="c_id" , column="cid"),
		@Result(property ="nid" , column="nid"),
		@Result(property ="mid" , column="mid"),
		
		@Result(property ="news" , column="nid" , one=@One(select = "com.chinasofiti.mapper.NewMapper.findbynid")
				
				 ),
	})
	List<Collect> getNewcollect(Integer mid);
	


	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
