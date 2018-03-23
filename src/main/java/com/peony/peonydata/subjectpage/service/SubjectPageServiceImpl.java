package com.peony.peonydata.subjectpage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.subjectpage.dao.SubjectPageMapper;
import com.peony.peonydata.subjectpage.model.SubjectPage;

@Service
public class SubjectPageServiceImpl implements SubjectPageService {

    @Resource
    private SubjectPageMapper subjectPageMapper;

    @Override
    public Pagination<SubjectPage> selectByPage(SubjectPage record) {
        List<SubjectPage> list = this.subjectPageMapper.selectBySubjectPage(record);
        return new Pagination<SubjectPage>(list, record.getPageParameter());
    }

    @Override
    public int deleteByPrimaryKey(String[] ids) {
        for (String id : ids) {
            this.subjectPageMapper.deleteByPrimaryKey(id);
        }
        return 0;
    }

    @Override
    public int updateSubjectPageState(String[] ids, Integer polarity) {
        SubjectPage sp = new SubjectPage();
        for (String id : ids) {
            sp.setId(id);
            sp.setPolarity(polarity);
            this.subjectPageMapper.updateByPrimaryKeySelective(sp);
        }

        return 0;
    }

    @Override
    public SubjectPage selectByPrimaryKey(String id) {
        return this.subjectPageMapper.selectByPrimaryKey(id);
    }

}
