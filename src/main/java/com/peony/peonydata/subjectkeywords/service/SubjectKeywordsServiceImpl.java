package com.peony.peonydata.subjectkeywords.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.subjectkeywords.dao.SubjectKeywordsMapper;
import com.peony.peonydata.subjectkeywords.model.SubjectKeywords;

@Service
public class SubjectKeywordsServiceImpl implements SubjectKeywordsService {
    @Resource
    private SubjectKeywordsMapper subjectKeywordsMapper;

    @Override
    public List<SubjectKeywords> selectSubjectListBySubjectId(Integer subjectId) {
        return this.subjectKeywordsMapper.selectSubjectListBySubjectId(subjectId);
    }

    @Override
    public int deleteBySubjectId(Integer subjectId) {
        return this.subjectKeywordsMapper.deleteBySubjectId(subjectId);
    }

    @Override
    public int insertSelective(SubjectKeywords record) {
        return this.subjectKeywordsMapper.insertSelective(record);
    }

    @Override
    public SubjectKeywords selectBySubjectIdAndName(SubjectKeywords record) {

        return this.subjectKeywordsMapper.selectBySubjectIdAndName(record);
    }

    @Override
    public int updateBySubjectIdAndName(SubjectKeywords record) {
        return this.subjectKeywordsMapper.updateBySubjectIdAndName(record);
    }

}
