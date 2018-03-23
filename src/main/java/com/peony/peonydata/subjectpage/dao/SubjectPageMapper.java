package com.peony.peonydata.subjectpage.dao;

import java.util.List;

import com.peony.peonydata.subjectpage.model.SubjectPage;

public interface SubjectPageMapper {
    int deleteByPrimaryKey(String id);

    int insert(SubjectPage record);

    int insertSelective(SubjectPage record);

    SubjectPage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SubjectPage record);

    int updateByPrimaryKey(SubjectPage record);
    
     List<SubjectPage>  selectBySubjectPage(SubjectPage record);
}