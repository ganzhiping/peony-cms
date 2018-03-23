package com.peony.peonydata.warning.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peony.core.base.controller.BaseController;
import com.peony.core.common.utils.UUIDGenerator;
import com.peony.peonydata.login.model.PhoneLogin;
import com.peony.peonydata.login.service.PhoneLoginService;
import com.peony.peonydata.subjectpage.model.SubjectPage;
import com.peony.peonydata.subjectpage.service.SubjectPageService;
import com.peony.peonydata.warning.model.Warning;
import com.peony.peonydata.warning.service.WarningService;

/**
 * 后台发送预警
 * @authorjhj
 */
@Controller
@RequestMapping("/warning")
public class WarningController extends BaseController{

	@Autowired
	private WarningService warningService; 
	
	@Autowired
	private SubjectPageService subjectPageService;
	
	@Autowired
	private PhoneLoginService phoneLoginService;
	
	 @RequestMapping(value = "/saveWarning", method = RequestMethod.GET, produces="text/plain;charset=utf-8")
	 @ResponseBody	
	 public  String saveWarning(HttpServletRequest request,HttpServletResponse response) {
			String ids= request.getParameter("ids");
			
			String [] arry=ids.split(",");
			for(String id:arry){
			
				SubjectPage subjectPage  = this.subjectPageService.selectByPrimaryKey(id);
				JSONObject jsonObject = new JSONObject();
				if(subjectPage!=null){
					Warning warning = new Warning();
					
					PhoneLogin phoneLogin = new PhoneLogin();
					phoneLogin.setUserId(subjectPage.getUserId());
					phoneLogin.setType("1");
					List<PhoneLogin> list = phoneLoginService.selectByUserId(phoneLogin);
					String waringId= UUIDGenerator.random();
					try {
						JSONArray array = new JSONArray();
						for(int i=0;i<list.size();i++){
							JSONObject object = new JSONObject();
							PhoneLogin phone = list.get(i); 
							object.put("token", phone.getMacId());
							object.put("time", phone.getDndTime()+"");
							
							array.add(object);
						}
						toSendYJ(subjectPage.getUserId().toString(),subjectPage.getTitle(),waringId,"1",array.toString());
					}catch (IOException e) {}
					
					warning.setWarningId(waringId);
					warning.setPageId(String.valueOf(subjectPage.getPageid()));
					warning.setTitle(subjectPage.getTitle());
					warning.setWarnTime(new Date());
					warning.setUrl(subjectPage.getUrl());
					warning.setSummary(subjectPage.getSummary());
					// --用户id
					warning.setUserId(subjectPage.getUserId());
					warning.setType(0);
					warning.setIsRead("0");
					warning.setClickcount(subjectPage.getClickcount());
					warning.setDownloaddate(subjectPage.getDownloaddate());
					warning.setForwardcount(subjectPage.getForwardcount());
					warning.setPolarity(subjectPage.getPolarity());
					warning.setPublishdate(subjectPage.getPublishdate());
					warning.setReplycount(subjectPage.getReplycount());
					warning.setWaringType(subjectPage.getType());
					warning.setWebsite(subjectPage.getWebsite());
					warningService.insertSelective(warning);
				
				}else{
						
				}
			}
			return null;
		}
	
	 /**
		 * 手机端  发送预警
		 * userId/title/uuid/type//token_time
		 * @throws IOException 
		 * @throws ClientProtocolException 
		 * */
		private void toSendYJ(String userId,String title,String uuid,String type,String token_time) throws ClientProtocolException, IOException{
			String url="http://down.peonydata.com/Push/PushService";
			List<NameValuePair> params = new ArrayList<NameValuePair>();
		    params.add(new BasicNameValuePair("userId", userId)); 
		    params.add(new BasicNameValuePair("title", title)); 
		    params.add(new BasicNameValuePair("uuid", uuid));
		    params.add(new BasicNameValuePair("type", type)); 
		    params.add(new BasicNameValuePair("token_time", token_time)); 
		    topost(url,params);
		}
		
		public static String topost(String url,List<NameValuePair> ce) throws ClientProtocolException, IOException{
			HttpPost httpPost = new HttpPost(url);
	        HttpResponse httpResponse = null; 
	            // 设置httpPost请求参数 
	            httpPost.setEntity(new UrlEncodedFormEntity(ce, HTTP.UTF_8)); 
	            httpResponse = new DefaultHttpClient().execute(httpPost); 
	            if (httpResponse.getStatusLine().getStatusCode() == 200) { 
	                // 第三步，使用getEntity方法活得返回结果 
	                String str = EntityUtils.toString(httpResponse.getEntity()); 
	                return str;
	            } 
			return "";
		}
		
	
}
