package com.peony.peonydata.message.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.message.dao.MessageMapper;
import com.peony.peonydata.message.model.Message;

/**
 * 站内消息
 *
 * @author jhj
 * @version 1
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> selectMessages() {
        return this.messageMapper.selectMessages();
    }

    @Override
    public int deleteByPrimaryKey(Integer messageId) {
        return this.messageMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public int insert(Message record) {
        return this.messageMapper.insert(record);
    }

    @Override
    public int insertSelective(Message record) {
        return this.messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByPrimaryKey(Integer id) {
        return this.messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Message record) {
        return this.messageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Message record) {
        return this.messageMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<Message> selectByPage(Message record) {
        List<Message> list = this.messageMapper.selectByPage(record);
        return new Pagination<Message>(list, record.getPageParameter());
    }

}
