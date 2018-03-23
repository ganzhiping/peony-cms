package com.peony.peonydata.subjectkeywords.dao;

import java.util.List;

import com.peony.peonydata.subjectkeywords.model.SubjectKeywords;



public interface SubjectKeywordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectKeywords record);

    int insertSelective(SubjectKeywords record);

    SubjectKeywords selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectKeywords record);

    int updateByPrimaryKey(SubjectKeywords record);
    /**
     * 根据分类表id查询关键词列表
     * @param pid
     * @return
     */
    List<SubjectKeywords> selectSubjectListBySubjectId(Integer subjectId);
    /**
     * 根据分类节点id删除该节点下的关键词
     * @param id
     * @return
     */
    int deleteBySubjectId(Integer subjectId);
    /**
     * 根据subject和name查询出地域数据
     * @param record
     * @return
     */
    SubjectKeywords selectBySubjectIdAndName(SubjectKeywords record);
    /**
     * 根据subject和name修改地域关键词
     * @param record
     * @return
     */
    int updateBySubjectIdAndName(SubjectKeywords record);
}