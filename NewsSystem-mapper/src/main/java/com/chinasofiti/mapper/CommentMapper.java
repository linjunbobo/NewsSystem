package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Comments;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
@Repository
public interface CommentMapper extends tk.mybatis.mapper.common.Mapper<Comments> {
	@Select("SELECT * FROM  comments c ,manager m WHERE  c.`mid`=m.`mid`" + 
			"AND  c.`nid`=#{nid} AND c.type=1")	
	@Results({
		@Result(property="cid" ,column="cid"),
		@Result(property="ccontent" ,column="ccontent"),
		@Result(property="nid" ,column="nid"),
		@Result(property="time" ,column="time"),
		@Result(property="zan_count" ,column="zan_count"),
		@Result(property="manager" ,column="mid",one=@One(select="com.chinasofiti.mapper.ManagerMapper.findByid"))
		
		})
	List<Comments> findbycomment(String nid);
	
	
	@Update("UPDATE comments SET zan_count=#{zan_count1} WHERE cid=#{cid} ")
	void updatezancout(@Param(value = "cid")  String cid,@Param(value = "zan_count1") int zan_count1);

	@Select("SELECT * FROM comments c ,news n WHERE c.`nid`=n.`nid` AND c.`mid`=#{mid} ORDER BY c.`time` DESC")	
	@Results({
		@Result(property="cid" ,column="cid"),
		@Result(property="ccontent" ,column="ccontent"),
		@Result(property="nid" ,column="nid"),
		@Result(property="time" ,column="time"),
		@Result(property="zan_count" ,column="zan_count"),
		@Result(property="mid" ,column="mid"),
		@Result(property ="type" , column="type"),
		@Result(property="news" ,column="nid",one=@One(select="com.chinasofiti.mapper.NewMapper.findbynid"	))
		
		})
	List<Comments> getcomment(Integer mid);



	@Update("update  comments set checkid=#{checkid},reason=#{reason},type=#{type} where cid=#{cid}")
	void updateby(@Param(value = "checkid") Integer checkid,@Param(value = "cid") String cid, @Param(value = "reason") String reason,@Param(value = "type")  Integer type);

	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

}
