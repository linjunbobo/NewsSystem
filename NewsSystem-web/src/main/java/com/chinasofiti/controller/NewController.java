package com.chinasofiti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofiti.beans.Autor;
import com.chinasofiti.beans.Category;
import com.chinasofiti.beans.Collect;
import com.chinasofiti.beans.Comments;
import com.chinasofiti.beans.History;
import com.chinasofiti.beans.Manager;
import com.chinasofiti.beans.New;
import com.chinasofiti.beans.Newcheck;
import com.chinasofiti.beans.Tuijian;
import com.chinasofiti.beans.Zan_count;
import com.chinasofiti.service.IAutorService;
import com.chinasofiti.service.ICategoryService;
import com.chinasofiti.service.ICollectService;
import com.chinasofiti.service.ICommentService;
import com.chinasofiti.service.IHistoryService;
import com.chinasofiti.service.IManagerService;
import com.chinasofiti.service.INewcheckService;
import com.chinasofiti.service.INewsService;
import com.chinasofiti.service.ITuijianService;
import com.chinasofiti.service.IZan_countService;
import com.chinasofiti.service.IsysService;
import com.github.pagehelper.PageHelper;


@Controller
@RequestMapping("/new")

public class NewController extends BaseController {
	@Autowired
	private INewsService newservice;
	@Autowired
	private IAutorService autorService;
	@Autowired
	private INewcheckService newcheckService;
	@Autowired
	private ICommentService commentService;
	@Autowired
	private IManagerService ManagerService;
	@Autowired
	private ICollectService CollectService;
	@Autowired
	private IZan_countService zan_countService;
	@Autowired
	private IHistoryService historytService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ITuijianService tuijianService;
	
	
	//审核新闻
	@RequestMapping(path = "/findnewall", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String,Object> findnewall(New news ,int rows,int page) {
		
		//加入分页
		Map<String, Object> map =new HashMap<String, Object>();
		PageHelper.startPage(page, rows);
		List<New> lsitnews = newservice.findBy(news);
		int total =newservice.findtolal(news);
		
		map.put("total", total);
		map.put("rows", lsitnews);
		return map;
	}
	
	
	//查询所有通过审核的新闻
	@RequestMapping(path = "/getPassNew", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String,Object> getPassNew(New news ,int rows,int page) {
		//加入分页
		Map<String, Object> map =new HashMap<String, Object>();
		

		List<New> lsitnews = newservice.findBytitle(news,page,rows);
		if(news.getState()==null) {
			news.setState(1);
		}
		int total =newservice.findtolal(news);
		
		map.put("total", total);
		map.put("rows", lsitnews);
		return map;
	}
	
	//分类查新闻
	@RequestMapping(path = "/findnew", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<New> findnew(New  news) {
		
			
		return newservice.findBy(news);
	}
	
	//新闻推荐新闻
	@RequestMapping(path = "tuijian", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<Tuijian> tuijian(HttpSession session) {
		
		  Manager manager=(Manager)session.getAttribute("manager");
		  
		  if(manager==null) { return null; } else {
			 
			
			  
			  Tuijian tuijian =new Tuijian();
			  tuijian.setMid(manager.getMid());
			 List<Tuijian> tuijiannews = tuijianService.gettuijiannews(manager.getMid());
			  //System.out.println(tuijiannews);
			  return tuijiannews;
		  }

	}
	//添加新闻
	
	@RequestMapping(path = "/addnews", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String, Object> addnews(New  news) {
		news.setState(0);
		news.setTime(new Timestamp(System.currentTimeMillis()));
		
		try {
			newservice.add(news);
			return returnAjax("success", "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			return returnAjax("failure", "添加失败");
		}
	
	}
	
	//新闻审核
	@RequestMapping(path = "/checknew", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String, Object> checknew(New  news,HttpSession session) {
		
		
		
			Manager checker = (Manager)session.getAttribute("manager");
			Integer usernameid = checker.getMid();
			String nid = news.getNid();
			String reason = news.getReason();
			Integer state = news.getState();
			
			newservice.updatebykey(usernameid,nid,reason,state);
			return returnAjax("success", "添加成功");
	
		
		
		
	}
	
	//根据ID查找新闻分类表
	@RequestMapping(path = "/findtypebyid", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Category findtypebyid(New news) {
		Integer typeid = news.getType();
		Category i = null;
		if (typeid != null) {
			i = newservice.findtypebyid(typeid);
		}

		return i;
		
	}	
	//查找新闻分类表
	@RequestMapping(path = "/findtype", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String, Object> findtype(HttpSession seesion ) {
		 Map<String, Object>  map=new HashMap<String, Object>();
		 
		
		Manager manager = (Manager)seesion.getAttribute("manager");
		map.put("manager", manager);
		map.put("Category", categoryService.findAll());
		
		
	
	

		return  map;
	}
	
	

	@RequestMapping(path = "/findautorbyid", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Autor findautorbyid(Autor autor) {
		String autorid = autor.getAid();
		Autor i = null;
		if (autorid != null) {
			i = autorService.findALLByid(autorid);

		}

		return i;
	}
	
	@RequestMapping(path = "/findcheckbyid", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<Newcheck> findcheckbyid(New news) {
		String nid = news.getNid();
		List<Newcheck> i = newcheckService.findByNid(nid);
		return i;
	}
	
	
		//新闻详情
	@RequestMapping(path = "/findbynid", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public New findbynid(New news,HttpSession session) {
		New date = newservice.findALLByid(news.getNid());
		
		Manager manager=(Manager)session.getAttribute("manager");
		  
		  if(manager==null) {  } else {
		  	new Thread(new Runnable() {
				@Override
				public void run() {
					newservice.gettuijian(manager.getMid(),news.getNid());
				}
			}).start();

		 }
		return date;

	}
	@RequestMapping(path = "/removenew", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String, Object> removenew(New news) {
		newservice.remove(news);
		
		return returnAjax("success", "删除成功");

	}
	
	
	//查根据新闻评论
	@RequestMapping(path = "/findcomment", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<Comments>  findcomment(New news) {
		/*
		 * Comments(); Comment.setMid(news.getNid()); List<Comments> comments =
		 * commentService.findBy(Comment); for (Comments comments2 : comments) {
		 * 
		 * Manager user = ManagerService.findALLByid(comments2.getMid());
		 * 
		 * }
		 */
		  Map<String, Object> map=new HashMap<String, Object>();
		 

		List<Comments> comment=commentService.findbycomment(news.getNid());
		
		 
		return comment;

	}
	//查询未审核所有评论
	@RequestMapping(path = "/findAllcomment", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public   Map<String, Object> findAllcomment(Comments com,int page,int rows) {
		  Map<String, Object> map=new HashMap<String, Object>();
			 
		  com.setType(0);
		  PageHelper.startPage(page, rows);
		  List<Comments> comment=commentService.findBy(com);
	
		int total =commentService.gettotal(com);
		
		map.put("total", total);
		map.put("rows", comment);
		return map;
			

	}
	//查询审核通过和没通过的评论
	@RequestMapping(path = "/getpasscomment", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public   Map<String, Object> getpasscomment(Comments com,int page,int rows) {
		  Map<String, Object> map=new HashMap<String, Object>();
			 if(com.getType()==null) {
				 com.setType(1);
			 }
		 
		  PageHelper.startPage(page, rows);
		  List<Comments> comment=commentService.findBy(com);
		  int total =commentService.gettotal(com);
		
		map.put("total", total);
		map.put("rows", comment);
		return map;
			

	}
	

	//添加评论
	@RequestMapping(path = "/addcomment", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String, Object> addcomment(Comments comment,HttpSession session) {
	
		
		Manager manager = (Manager)session.getAttribute("manager");
		if(manager==null) {
			return returnAjax("failure", "未登录");
			
		}else {
			  String mid = manager.getMid().toString();
			  comment.setMid(mid);
			  comment.setType(0);
			  comment.setZan_count(0);
			  
			//comment.setMid();
			
			commentService.add(comment);
			return returnAjax("success", "成功");
			
		}
		
		
		

	}
	
	
	//评论审核
		@RequestMapping(path = "/checkcomment", produces = { "application/json;charset=utf-8" })
		@ResponseBody
		public Map<String, Object> checkcomment(Comments  comment,HttpSession session) {
			
		

				Manager checker = (Manager)session.getAttribute("manager");
				Integer checkid = checker.getMid();
				String cid = comment.getCid();
				 String reason = comment.getReason();
				Integer type = comment.getType();
				
				commentService.updateby(checkid,cid,reason,type);
		
				return returnAjax("success", "添加成功");
		
			
			
			
		}
	//收藏取消收藏
	@RequestMapping(path ="/addcollect", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public  Map<String, Object>addnew(String nid,String img,HttpSession session) {
	
		Manager manager = (Manager)session.getAttribute("manager");
		if(manager==null) {
			return returnAjax("failure", "未登录");
			
		}else{
			Collect collect =new Collect();
			 int mid = manager.getMid();
			 collect.setMid(mid);
			 int Intnid=Integer.parseInt(nid); 
				 collect.setNid(Intnid);
				 
				
			if(img.equals("/themes/img/icon/like-2.png")) {
			
				
				CollectService.removeby( nid , mid);
				
			}else if(img.equals("/themes/img/icon/like-1.png")) {
				 CollectService.add(collect);
			
			}
	 
			 return returnAjax("success", "成功");
		
			  }

	}
	//查看用户是否收藏了
	@RequestMapping(path = "/findcollect", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public Map<String, Object>  findcollect(String nid,HttpSession session) {
		
	
		  Manager manager = (Manager)session.getAttribute("manager");
			if(manager==null) {
				return returnAjax("failure", "未登录");
			}else {
				Collect collect =new Collect();
				 int mid = manager.getMid();
				 collect.setMid(mid);
				 int Intnid=Integer.parseInt(nid); 
				 collect.setNid(Intnid);
				 Collect rs =CollectService.findcollect(nid,mid);
				//List<Collect> rs = CollectService.findBy(collect);
				
				 if(rs==null) {
					 return returnAjax("failure", "此文章没收藏");
					 
				 }else {
					 return returnAjax("success", "用户收藏了");
				 }
			}

	}
	//查看用户是否收藏了
	@RequestMapping(path = "/findcollectBynid", produces = { "application/json;charset=utf-8" })
	@ResponseBody
	public List<Collect>  findcollectBynid (String nid) {
	
				Collect collect =new Collect();

				 int Intnid=Integer.parseInt(nid); 
				 collect.setNid(Intnid);
				  List<Collect> rs = CollectService.findBy(collect);
				return rs;
				
			
			
	}
	
	
			
			//点赞添加修改
			@RequestMapping(path ="/addzan", produces = { "application/json;charset=utf-8" })
			@ResponseBody
			public  Map<String, Object>addzan(String state,String cid,String zan_count,String nid,HttpSession session) {
				
				
				  Manager manager = (Manager)session.getAttribute("manager");
			
				  //System.out.println(cid);
					if(manager==null) {
						return returnAjax("failure", "未登录");
					}else {
						  Integer mid = manager.getMid();
						  Zan_count zan =new Zan_count();
						  zan.setMid(mid);
						  int cid1=Integer.parseInt(cid); 
						 
						  zan.setCid(cid1);
						  int nid1=Integer.parseInt(nid); 
						  zan.setNid(nid1);
						  
						if(state.equals("1")) {
					  //点赞+1
					 int zan_count1=Integer.parseInt(zan_count)+1;
					commentService.updatezancout(cid,zan_count1);
						zan_countService.add(zan);
					
						}
						if(state.equals("2")) {
					//点赞-1
					 int zan_count1=Integer.parseInt(zan_count)-1;
					commentService.updatezancout(cid,zan_count1);
					zan_countService.deletcby(cid,mid);
						}
					
				 return returnAjax("success", "用户收藏了");
					
			

			}	 

			}
			//查找用户是否点赞
			@RequestMapping(path = "/findzan", produces = { "application/json;charset=utf-8" })
			@ResponseBody
			public Map<String, Object>  findzan(String nid,HttpSession session) {
				
				 Map<String, Object> map =new HashMap<String, Object>();
				  Manager manager = (Manager)session.getAttribute("manager");
					if(manager==null) {
						return returnAjax("failure", "未登录");
					}else {
						Zan_count zan=new Zan_count();
						zan.setNid(Integer.parseInt(nid));
						zan.setMid(manager.getMid());
						List<Zan_count> dianzan = zan_countService.findzan(nid,manager.getMid());
						//System.out.println(dianzan);
						//List<Collect> rs = CollectService.findBy(collect);
						
						 if(dianzan==null) {
							 return returnAjax("failure", "没点赞过");
							 
						 }else {
							 map.put("dianzan", dianzan);
							 return map;
						 }
					}
			}
			
			//根据新闻id查阅读数
			@RequestMapping(path = "/getzanbynid", produces = { "application/json;charset=utf-8" })
			@ResponseBody
			public Map<String, Object> getzanbynid(String nid) {
				
				 Map<String, Object> map =new HashMap<String, Object>();
				 History history =new History();
				 history.setNid(Integer.parseInt(nid));
				List<History> readcount = historytService.findBy(history);
				int count=0;
				if(readcount.size()!=0) {
				for (History zan_count : readcount) {
					
					count+=zan_count.getCount();
				}}
				map.put("count", count);
				
				return map;
				
			}
			//添加浏览记录
			@RequestMapping(path = "/history", produces = { "application/json;charset=utf-8" })
			@ResponseBody
			public Map<String, Object>  history(String nid,HttpSession session) {
				
				 Map<String, Object> map =new HashMap<String, Object>();
				  Manager manager = (Manager)session.getAttribute("manager");
					if(manager==null) {
						return returnAjax("failure", "未登录");
					}else {
						historytService.addhistory(nid,session);
					
						return returnAjax("success", "添加成功");
						 }
					}
			
			
			
			//wangedit 图片把图片存储到服务器
			@RequestMapping(path = "/upload", produces = { "application/json;charset=utf-8" })
			@ResponseBody
			public Map<String, Object>  file(HttpServletRequest request,MultipartFile myFile) throws IllegalStateException, IOException {
			//	System.out.println("myFile="+myFile);
				Map<String, Object> map =new HashMap<String, Object>();
				//获取保存文件的真实路径
				//String savePath=request.getServletContext().getRealPath("/uploads");
				String savePath="D:\\pic";
				//获取文件上传名字
				String filename =myFile.getOriginalFilename();
			//	System.out.println("filename="+filename);
				//创建File对象
				File file =new File(savePath,filename);
				if(!file.getParentFile().exists()){
					file.getParentFile().mkdirs();
				}
				//System.out.println("file"+file);
				try {
					//保存文件
					myFile.transferTo(file);
					String imgIrl=savePath+"\\"+filename;
					
					// 图片地址
					//String imgUrl = request.getContextPath() + "/uploads/" + filename;
					String imgUrl = "\\pic"+"\\"+filename;
					map.put("errno", 0);
					  String[] myList = {imgUrl};
					map.put("data", myList);
					return map;
					
				} catch (Exception e) {
					// TODO: handle exception
				}
					 	
				
				return map;
					
				}
			
			
		
			


	
}
