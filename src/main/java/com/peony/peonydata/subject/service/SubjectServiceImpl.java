package com.peony.peonydata.subject.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.subject.dao.SubjectMapper;
import com.peony.peonydata.subject.model.Subject;

/**
 * 订制舆情实现类
 *
 * @author vv
 *
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> selectUserKeywsByUserId(Integer userId) {
        return this.subjectMapper.selectSubjectByUserId(userId);
    }

    @Override
    public Subject selectByPrimaryKey(Integer id) {
        return this.subjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Subject> selectChildnodesById(Integer id) {
        return this.subjectMapper.selectChildnodesById(id);
    }

    @Override
    public List<Subject> selectNodesByUserId(Integer userId) {
        return this.subjectMapper.selectNodesByUserId(userId);
    }

    @Override
    public List<Subject> selectSubjectByUserIdAndPid(Subject subject) {
        return this.subjectMapper.selectSubjectByUserIdAndPid(subject);
    }

    @Override
    public boolean selectCountByPid(Subject subject) {
        subject = this.subjectMapper.selectCountByPid(subject);
        return subject.getCount() > 0;
    }

    @Override
    public List<Subject> selectSubjectByUserIdExclusive(Subject subject) {
        return this.subjectMapper.selectSubjectByUserIdExclusive(subject);
    }

    @Override
    public List<Subject> selectChildnodesByUserId(Integer userId) {

        return this.subjectMapper.selectChildnodesByUserId(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(Subject record) {
        return this.subjectMapper.updateByPrimaryKeySelective(record);
    }

}
