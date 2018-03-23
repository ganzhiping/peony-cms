package com.peony.peonydata.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *字符串操作工具类
 */
public class StringRegular {

	/**
	 * 将字符串中的回车 制表符  换行符 转化为空格
	 * @param so
	 * @return
	 */
	public static final String remove(String so){
		 Pattern p = Pattern.compile("[\r|\n|\t]*");
         Matcher m = p.matcher(so);
         so = m.replaceAll(" ");
		 return so;
	}
	
	
	/**
	 * jhj
	 * 将全角空格转化为半角空格
	 * @param ss
	 * @return
	 */
	public static final String removeSpace(String ss){
	     byte[] t = ss.getBytes();
	     for(int i=0;i<t.length;i++){
	       if(t[i] == -95 && t[i+1]==-95 ){
	        t[i]=32;
	        if(i+1==t.length-1){
	           t[i+1] = 0;
	        }else{
	         for(int j=i+1;j+1<t.length;j++){
	          t[j]=t[j+1];
	          if(j+1 == t.length-1) t[j+1] = 32;
	         }
	        }
	        
	          }             
	      }
	     return new String(t);
	    }
	
	/**
	 * 将list 转化为','号分隔的字符串
	 * @param list
	 * @return
	 */
	public static String listToString(List list) {  
	    StringBuilder sb = new StringBuilder();  
	    if (list != null && list.size() > 0) {  
	        for (int i = 0; i < list.size(); i++) {  
	            if (i < list.size() - 1) {  
	                sb.append(list.get(i) + ",");  
	            } else {  
	                sb.append(list.get(i));  
	            }  
	        }  
	    }  
	    return sb.toString();  
	}  
}
