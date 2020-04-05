package com.chinasofiti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.Menu;
import com.chinasofiti.beans.New;
@Repository
public interface NewMapper extends tk.mybatis.mapper.common.Mapper<New> {
	
	@Select("select * from category where id=#{typeid}" )
	Category findtypebyid(Integer typeid);
	
	
	@Select("select * from news where nid=#{nid}" )
	New findbynid(Integer nid);
	/*
	 * @Select("select * from manager") List<Manager> findManager(Manager manager);
	 */

 @Update("update news set state=#{state},reason=#{reason},usernameid=#{usernameid} where nid=#{nid}")
		void updatebykey(@Param(value = "usernameid")  Integer usernameid,@Param(value = "nid") String nid, @Param(value = "reason") String reason,@Param(value = "state") Integer state);

 		
   




}
