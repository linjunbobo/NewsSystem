package com.chinasofiti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.History;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Tuijian;
import com.chinasofiti.mapper.HistoryMapper;
import com.chinasofiti.mapper.ManagerMapper;
import com.chinasofiti.mapper.NewMapper;
import com.chinasofiti.mapper.TuijianMapper;
import com.chinasofiti.service.ICommonService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.IsysService;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.mysql.jdbc.StringUtils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public  class NewServiceImpl extends CommonServiceImpl<New> implements INewsService {

	@Autowired
	private NewMapper newMapper;
	@Autowired
	private HistoryMapper historyMapper;
	@Autowired
	private TuijianMapper tuijianMapper;


	@Override
	protected Mapper getMapper() {
		// TODO Auto-generated method stub
		return this.newMapper;
	}

	@Override
	public Category findtypebyid(Integer typeid) {
		// TODO Auto-generated method stub
		return newMapper.findtypebyid(typeid);
	}

	@Override
	public void updatebykey(Integer usernameid, String nid, String reason, Integer state) {
		// TODO Auto-generated method stub
		newMapper.updatebykey(usernameid,nid,reason,state);
	}

	@Override
	public List<New> findBytitle(New news,int page ,int rows) {
		
		//设置模糊查询体条件
		Example ex =new Example(New.class);
		Criteria c = ex.createCriteria();
	
		if(!StringUtils.isNullOrEmpty(news.getTitle())) {
			c.andLike("title", "%"+news.getTitle()+"%");
		}
		
		c.andEqualTo("state", news.getState()==null? 1:news.getState());
		ex.setOrderByClause("time DESC");
		PageHelper.startPage(page, rows);
		List<New> list =newMapper.selectByExample(ex);
		return list;
	}

	@Override
	public int findtolal(New news) {
		// TODO Auto-generated method stub
		//设置模糊查询体条件
		Example ex =new Example(New.class);
		Criteria c = ex.createCriteria();
	
		if(!StringUtils.isNullOrEmpty(news.getTitle())) {
			c.andLike("title", "%"+news.getTitle()+"%");
		}
		
		c.andEqualTo("state", news.getState()==null? 1:news.getState());
		ex.setOrderByClause("time DESC");
		return newMapper.selectCountByExample(ex);
	}

	
	//新闻推荐
	
	
	@Override
	public void gettuijian(Integer mid,String nid) {
		// TODO Auto-generated method stub		
		//获取用户历史记录中的新闻
		//History history=new History();
		//history.setMid(13);	
			
		List<History> historyList = historyMapper.selectBymid(mid);
		
		
		
		//推荐内容准备
		Suggester suggester = new Suggester();
		List<New> news = newMapper.selectAll();
		for (New new1 : news) {
			String content=new1.getContent();
			//定义正则
			String rex="<.*?>";
			//去除文章的div等html标签
			String rexcontent = content.replaceAll("<.*?>","");
			//去除各种$开头空格等标识符
			String rexcontent2 = rexcontent.replaceAll("&\\w{4,}","");
			//去除各种开头缩进
			String rexcontent3 = rexcontent2.replaceAll(" *","");
					
			//文本推荐
			suggester.addSentence(rexcontent3);		
			
		}
		
			New newsbykey = newMapper.selectByPrimaryKey(nid);
			
			String content = newsbykey.getContent();
			//去除文章的div等html标签
			String rexcontent = content.replaceAll("<.*?>","");
			//去除各种$开头空格等标识符
			String rexcontent2 = rexcontent.replaceAll("&\\w{4,}","");
			//去除各种开头缩进
			String rexcontent3 = rexcontent2.replaceAll(" *","");
			//短语提取
			//List<String> fenci = HanLP.extractPhrase(rexcontent3, 3);
			//关键词提取
			List<String> fenci = HanLP.extractKeyword(rexcontent3, 5);
			int count =2;
			//获取推荐的3篇文章
			List<String> ss = suggester.suggest(fenci.toString(), 5);
			
			test(mid,ss, news,  count,nid);	}

	private void test(Integer mid, List<String> ss, List<New> news, int count,String nid) {
		
		
		for (New new1 : news) {
		String new1content=new1.getContent();
		//定义正则
		String rex="<.*?>";
		//去除文章的div等html标签
		String new1rexcontent = new1content.replaceAll("<.*?>","");
		//去除各种$开头空格等标识符
		String new1rexcontent2 = new1rexcontent.replaceAll("&\\w{4,}","");
		//去除各种开头缩进
		String new1rexcontent3 = new1rexcontent2.replaceAll(" *","");
		//查文章的nid			
		if(ss.get(count-1).equals(new1rexcontent3)) {

		
		
		Tuijian tuijian=new Tuijian();
		tuijian.setMid(mid);
		tuijian.setNid(Integer.parseInt(new1.getNid()));
		List<Tuijian> select = tuijianMapper.select(tuijian);
		if(select.size()==0) {
		
			tuijian.setState(0);
			tuijianMapper.insert(tuijian);
			
			
		}else {
			System.out.println(count);
			if(count<4) {test(mid,ss, news, count+1,nid);}
			
		}
		

}

		
}
	}



}
