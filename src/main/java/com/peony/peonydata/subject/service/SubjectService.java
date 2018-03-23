package com.peony.peonydata.subject.service;

import java.util.List;

import com.peony.peonydata.subject.model.Subject;


public interface SubjectService {
	
	
	 int updateByPrimaryKeySelective(Subject record);
	 /**
     * 查询出用户设置的节点
     */
    List<Subject> selectUserKeywsByUserId(Integer userId);
    /**
     * 根据id查询实体类
     */
    Subject selectByPrimaryKey(Integer id);
   
    /**
     * 根据节点id查询该节点下的子节点
     */
    List<Subject> selectChildnodesById(Integer id);
   
    /**
     * 查询该用户下的所根节点
     */
    List<Subject> selectNodesByUserId(Integer userId);
   
    
    /**
     * 通过用户id和pid查询订制舆情
     * @param subject
     * @return
     */
    List<Subject> selectSubjectByUserIdAndPid(Subject subject);
    
    boolean selectCountByPid(Subject subject);
    
    List<Subject> selectSubjectByUserIdExclusive(Subject subject);
    /**
     * 查询该用户下的所子节点
     */
    List<Subject> selectChildnodesByUserId(Integer userId);
}
