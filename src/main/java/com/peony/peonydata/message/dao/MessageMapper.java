package com.peony.peonydata.message.dao;

import java.util.List;

import com.peony.peonydata.information.model.Information;
import com.peony.peonydata.message.model.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> selectMessages();
    
	List<Message> selectByPage(Message record);
}