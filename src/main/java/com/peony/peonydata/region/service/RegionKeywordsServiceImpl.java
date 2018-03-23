package com.peony.peonydata.region.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.region.dao.RegionKeywordsMapper;
import com.peony.peonydata.region.model.RegionKeywords;
import com.peony.peonydata.subject.dao.SubjectMapper;
import com.peony.peonydata.subject.model.Subject;
import com.peony.peonydata.subjectkeywords.dao.SubjectKeywordsMapper;
import com.peony.peonydata.subjectkeywords.model.SubjectKeywords;
import com.peony.peonydata.userRegion.dao.UserRegionMapper;
import com.peony.peonydata.userRegion.model.UserRegion;
import com.peony.peonydata.util.WhJdcbConnection;

@Service
public class RegionKeywordsServiceImpl implements RegionKeywordsService {
    @Resource
    private RegionKeywordsMapper  regionKeywordsMapper;
    @Resource
    private UserRegionMapper      userRegionMapper;     // 用户-地域mapper
    @Resource
    private SubjectMapper         subjectMapper;
    @Resource
    private SubjectKeywordsMapper subjectKeywordsMapper;

    @Override
    public RegionKeywords selectByPrimaryKey(String regionid) {
        return this.regionKeywordsMapper.selectByPrimaryKey(regionid);
    }

    @Override
    public int updateByPrimaryKeySelective(RegionKeywords regionKeywords) {
        int i = this.regionKeywordsMapper.updateByPrimaryKeySelective(regionKeywords);
        if (i == 1) {
            String regionId = regionKeywords.getRegionid();
            if (regionId.length() == 6) {
                this.updateSubjectKeywords(regionId);
                regionId = regionId.substring(0, 4);
            }
            if (regionId.length() == 4) {
                this.updateSubjectKeywords(regionId);
                regionId = regionId.substring(0, 2);
            }
            if (regionId.length() == 2) {
                this.updateSubjectKeywords(regionId);
            }
        }
        return i;
    }

    /**
     * 修改地域关键词，修改每个用户设置的关键词中的地域关键词字段
     *
     * @param regionId
     */
    private void updateSubjectKeywords(String regionId) {
        // System.out.println(regionId+"****************************");
        // 查询出修改后的地域关键词组
        List<RegionKeywords> regionList = this.regionKeywordsMapper.selectByRegionId(regionId);
        StringBuffer allRegionKeyWords = new StringBuffer();
        for (RegionKeywords rkw : regionList) {
            allRegionKeyWords.append(rkw.getRegionwords());
            allRegionKeyWords.append(" ");
        }
        List<UserRegion> userRegion = this.userRegionMapper.findUserByRegionId(Integer.parseInt(regionId));
        for (UserRegion u : userRegion) {
            // System.out.println(u.getUserId()+"---");
            List<Subject> subject = this.subjectMapper.selectNodesByUserId(u.getUserId());
            for (Subject s : subject) {
                // System.out.println(s.getUserid()+"***"+s.getName()+"****"+s.getId());
                SubjectKeywords subjectKeywords = new SubjectKeywords();
                subjectKeywords.setSubjectid(s.getId());
                subjectKeywords.setName("area");
                // subjectKeywords=subjectKeywordsService.selectBySubjectIdAndName(subjectKeywords);
                // System.out.println(subjectKeywords.getKeywords()+"..........");
                subjectKeywords.setKeywords(allRegionKeyWords.toString());
                this.subjectKeywordsMapper.updateBySubjectIdAndName(subjectKeywords);
                // System.out.println(subjectKeywords.getKeywords()+"**..........");
                WhJdcbConnection whJdcbConnection = new WhJdcbConnection();
                whJdcbConnection.updateSubjectKeywords(subjectKeywords);
            }
        }
    }

    @Override
    public List<RegionKeywords> selectByRegionId(String regionid) {

        return this.regionKeywordsMapper.selectByRegionId(regionid);
    }

}
