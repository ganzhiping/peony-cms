package com.peony.peonydata.quartz;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.peony.peonydata.subject.model.Subject;
import com.peony.peonydata.subject.service.SubjectService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;
import com.peony.peonydata.userserve.model.UserServe;
import com.peony.peonydata.userserve.service.UserServeService;
import com.peony.peonydata.util.WhJdcbConnection;

/**
 * 定时器 监测用户过期时间  关键词失效时间 定时执行
 * @authorjhj
 */
public class ExpireJobTask implements ApplicationContextAware{
	 private static final Logger logger = LoggerFactory.getLogger(ExpireJobTask.class);
	 @Autowired
	 private ApplicationContext ctx;
	 
	 private static UserService userService;//用户service
	 
	 private static UserServeService userServeService;//用户服务service
	 
	 private static SubjectService subjectService;//定制舆情节点
	 
	 public void doBiz() {
		 // 执行业务逻辑
		 logger.info("quartz run... ...");
		 if(userService==null){
			 userService=(UserService)this.ctx.getBean("userService");
		 }
		 if(userServeService==null){
			 userServeService=(UserServeService)this.ctx.getBean("userServeService");
		 }
		 if(subjectService==null){
			 subjectService=(SubjectService)this.ctx.getBean("subjectServiceImpl");
		 }
		 
		 User user=new User();
		 user.setUserStatus("1");
		 List<User> list=userService.selectUsers(user);
		 long currentTime=System.currentTimeMillis();
		 Date updateTime=new Date();
		 for(User u:list){
			 Date dropTime=u.getExpiryTime();
			 if(dropTime!=null){
				 if(dropTime.getTime()<=currentTime){
					 u.setUserStatus("3");//失效
					 userService.updateByPrimaryKeySelective(u);
					 
					 UserServe us=userServeService.selectByUserId(u.getUserId());
					 us.setStatus("3");
					 userServeService.updateByKeySelective(us);
					
					 logger.info("用户：["+u.getLoginName()+"]已过期  过期时间为："+dropTime.toLocaleString());
					 
					 //获取用户设置的subject
					 List<Subject> ls=subjectService.selectUserKeywsByUserId(u.getUserId());
						 for(Subject subject:ls){
							 subject.setDroptime(dropTime);//设置关键词到期时间为用户到期时间
							 subject.setUpdateTime(updateTime);
							 subjectService.updateByPrimaryKeySelective(subject);
						     WhJdcbConnection whJdcbConnection = new WhJdcbConnection();
							 whJdcbConnection.UpdateSubject(subject);
							 logger.info("设置关键词同步库过期时间");
					 }
				 }
			 }
		 }
		 
		//对已经过期的用户进行关键词设置
		 user.setUserStatus("3");
		 list=userService.selectUsers(user);
		 for(User u:list){
			 Date dropTime=u.getExpiryTime();
			 List<Subject> ls=subjectService.selectUserKeywsByUserId(u.getUserId());
			 for(Subject subject:ls){
				 if(subject.getDroptime()==null){
					 subject.setDroptime(dropTime);//设置关键词到期时间为用户到期时间
					 subject.setUpdateTime(updateTime);
					 subjectService.updateByPrimaryKeySelective(subject);
				     WhJdcbConnection whJdcbConnection = new WhJdcbConnection();
					 whJdcbConnection.UpdateSubject(subject);
					 logger.info("设置关键词同步库过期时间-用户id："+u.getUserId());
				 }
			 }
		 }
		 user=null;
	    }
	 	@Override
		public void setApplicationContext(ApplicationContext arg0)
				throws BeansException {
			ctx = arg0;
		}
		public UserService getUserService() {
			return userService;
		}
		public void setUserService(UserService userService) {
			ExpireJobTask.userService = userService;
		}
		
	 	
}
