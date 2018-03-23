package com.peony.peonydata.feedback.dao;

import java.util.List;

import com.peony.peonydata.feedback.model.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer feedbackId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer feedbackId);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
    
    List<Feedback> selectFeedbacks();
    
	List<Feedback> selectByPage(Feedback record);
}