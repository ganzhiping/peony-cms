package com.peony.peonydata.userserve.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.report.dao.ReportConfigMapper;
import com.peony.peonydata.report.model.ReportConfig;
import com.peony.peonydata.subject.dao.SubjectMapper;
import com.peony.peonydata.subject.model.Subject;
import com.peony.peonydata.user.dao.UserMapper;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.userserve.dao.UserServeMapper;
import com.peony.peonydata.userserve.model.UserServe;
import com.peony.peonydata.util.WhJdcbConnection;

/**
 * 用户服务接口
 *
 * @date
 * @author jhj
 * @version 1
 */
@Service
public class UserServeServiceImpl implements UserServeService {

    @Resource
    private UserServeMapper    userServeMapper;    // 用户服务mapper

    @Resource
    private UserMapper         userMapper;         // 用户mapper

    @Resource
    private ReportConfigMapper reportConfigMapper; // 日报配置

    @Resource
    private SubjectMapper      subjectMapper;

    @Override
    public int insert(UserServe record) {
        return this.userServeMapper.insert(record);
    }

    @Override
    public int insertSelective(UserServe record) {
        User user = new User();
        user.setUserId(record.getUserId());
        user.setUserStatus(record.getStatus());
        user.setPlatformType(record.getPlatformType());
        if (record.getDeadline() != null) {
            try {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = sf.parse(record.getDeadline());
                user.setExpiryTime(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        this.userMapper.updateByPrimaryKeySelective(user);
        return this.userServeMapper.insertSelective(record);
    }

    @Override
    public int insertMobileSelective(UserServe record) {
        User user = new User();
        user.setUserId(record.getUserId());
        user.setUserStatus(record.getStatus());
        user.setPlatformType(record.getPlatformType());
        if ("".equals(record.getDeadline())) {
            record.setDeadline(null);
        }
        if (record.getDeadline() != null) {
            try {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = sf.parse(record.getDeadline());
                user.setExpiryTime(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        this.userMapper.updateByPrimaryKeySelective(user);
        return this.userServeMapper.insertSelective(record);
    }

    @Override
    public UserServe selectByPrimaryKey(Integer userserviceId) {
        return this.userServeMapper.selectByPrimaryKey(userserviceId);
    }

    @Override
    public int updateByPrimaryKeySelective(UserServe record) {
        User user = new User();
        user.setUserId(record.getUserId());
        user.setUserStatus(record.getStatus());
        user.setPlatformType(record.getPlatformType());

        if (record.getDeadline() != null) {
            try {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date d = sf.parse(record.getDeadline());
                user.setExpiryTime(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        this.userMapper.updateByPrimaryKeySelective(user);

        List<ReportConfig> list = this.reportConfigMapper.selectReportConfigByUserId(record.getUserId());
        ReportConfig rc = list.get(0);
        if (record.getReportCreate().equals("0")) {
            rc.setReportCreate("2");// 未开通
        } else {
            rc.setReportCreate("1");// 发送
        }

        if (record.getReportSend().equals("0")) {
            rc.setReportSend("2");// 未开通
        } else {
            rc.setReportSend("1");// 发送
        }
        this.reportConfigMapper.updateByPrimaryKeySelective(rc);

        // 获取用户设置的subject
        List<Subject> ls = this.subjectMapper.selectSubjectByUserId(user.getUserId());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date updateTime = new Date();
        for (Subject subject : ls) {
            try {
                Date dropTime = format1.parse(record.getDeadline());
                subject.setDroptime(dropTime);// 设置关键词到期时间为用户到期时间
                subject.setUpdateTime(updateTime);
                this.subjectMapper.updateByPrimaryKeySelective(subject);
                WhJdcbConnection whJdcbConnection = new WhJdcbConnection();
                whJdcbConnection.UpdateSubject(subject);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return this.userServeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMobileByPrimaryKeySelective(UserServe record) {
        User user = new User();
        user.setUserId(record.getUserId());
        user.setUserStatus(record.getStatus());
        user.setPlatformType(record.getPlatformType());
        if ("".equals(record.getDeadline())) {
            record.setDeadline(null);
        }
        if (record.getDeadline() != null) {
            try {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = sf.parse(record.getDeadline());
                user.setExpiryTime(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        this.userMapper.updateByPrimaryKeySelective(user);

        // List<ReportConfig>
        // list=this.reportConfigMapper.selectReportConfigByUserId(record.getUserId());
        // ReportConfig rc=list.get(0);
        // if(record.getReportCreate().equals("0")){
        // rc.setReportCreate("2");//未开通
        // }else{
        // rc.setReportCreate("1");//发送;
        // }
        //
        // if(record.getReportSend().equals("0")){
        // rc.setReportSend("2");//未开通
        // }else{
        // rc.setReportSend("1");//发送
        // }
        // this.reportConfigMapper.updateByPrimaryKeySelective(rc);
        return this.userServeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserServe record) {
        return this.userServeMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserServe selectByUserId(Integer id) {
        return this.userServeMapper.selectByUserId(id);
    }

    @Override
    public int updateByKeySelective(UserServe record) {
        return this.userServeMapper.updateByPrimaryKeySelective(record);
    }
}
