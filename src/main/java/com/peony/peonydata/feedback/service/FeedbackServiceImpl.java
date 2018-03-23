package com.peony.peonydata.feedback.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.feedback.dao.FeedbackMapper;
import com.peony.peonydata.feedback.model.Feedback;

/**
 * 站内消息
 *
 * @author jhj
 * @version 1
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public List<Feedback> selectFeedbacks() {
        return this.feedbackMapper.selectFeedbacks();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.feedbackMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Feedback record) {
        return this.feedbackMapper.insert(record);
    }

    @Override
    public Feedback selectByPrimaryKey(Integer id) {
        return this.feedbackMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Feedback record) {
        return this.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<Feedback> selectByPage(Feedback record) {
        List<Feedback> list = this.feedbackMapper.selectByPage(record);
        return new Pagination<Feedback>(list, record.getPageParameter());
    }

}
