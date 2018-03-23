package com.peony.peonydata.customer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.event.dao.EventMapper;
import com.peony.peonydata.key.dao.IdMapper;
import com.peony.peonydata.key.model.KeyGen;
import com.peony.peonydata.report.dao.ReportConfigMapper;
import com.peony.peonydata.report.model.ReportConfig;
import com.peony.peonydata.subscription.dao.SubscriptionMapper;
import com.peony.peonydata.subscription.model.Subscription;
import com.peony.peonydata.user.dao.UserMapper;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.userRegion.dao.UserRegionMapper;
import com.peony.peonydata.userRegion.model.UserRegion;
import com.peony.peonydata.userbaseclass.dao.UserBaseClassMapper;
import com.peony.peonydata.userbaseclass.model.UserBaseClass;
import com.peony.peonydata.userserve.dao.UserServeMapper;
import com.peony.peonydata.userserve.model.UserServe;

/**
 * 客户服务接口
 *
 * @author jhj
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private UserMapper          userMapper;
    @Resource
    private UserBaseClassMapper userBaseClassMapper;
    @Resource
    private UserRegionMapper    userRegionMapper;

    @Resource
    private EventMapper         eventMapper;

    @Resource
    private SubscriptionMapper  subscriptionMapper;

    @Resource
    private IdMapper            idMapper;

    @Resource
    private UserServeMapper     userServeMapper;

    @Resource
    private ReportConfigMapper  reportConfigMapper; // 日报配置
    /*
     * 将user userBaseClass userRegion subscription userServe分别存到各表中
     */

    @Override
    public int insertSelective(User user, UserBaseClass userBaseClass, UserRegion userRegion) {
        if (userBaseClass.getBaseclassId() != null) {
            this.userBaseClassMapper.insertSelective(userBaseClass);
        }
        if (userRegion.getRegionId() != null) {
            this.userRegionMapper.insertSelective(userRegion);
            // 保存 event_en数据 到Subscription

            Subscription subscription = new Subscription();
            subscription.setSubscriptionId(KeyGen.getInstance().getNextKey("subscription_id", this.idMapper));
            subscription.setUserId(String.valueOf(user.getUserId()));
            subscription.setEventId("");
            this.subscriptionMapper.insertSelective(subscription);
        }

        UserServe userServe = new UserServe();// 用户服务
        userServe.setUserId(user.getUserId());
        userServe.setUserserviceId(KeyGen.getInstance().getNextKey("userService_id", this.idMapper));

        ReportConfig rc = new ReportConfig();
        rc.setReportTempId("1");
        rc.setReportConfigId(KeyGen.getInstance().getNextKey("report_config_id", this.idMapper));
        rc.setUserId(user.getUserId());
        rc.setCreateTime("17");
        this.reportConfigMapper.insertSelective(rc);

        this.userServeMapper.insertSelective(userServe);
        return this.userMapper.insertSelective(user);
    }

    /*
     * 更新客户
     */
    @Override
    public int updateSelective(User user, UserBaseClass userBaseClass, UserRegion userRegion) {

        User u = this.userMapper.selectByPrimaryKey(user.getUserId());

        if (!u.getUserType().equals(user.getUserType())) {
            this.subscriptionMapper.deleteByUserId(String.valueOf(user.getUserId()));
            Subscription subscription = new Subscription();
            subscription.setSubscriptionId(KeyGen.getInstance().getNextKey("subscription_id", this.idMapper));
            subscription.setUserId(String.valueOf(user.getUserId()));
            subscription.setEventId("");
            this.subscriptionMapper.insertSelective(subscription);
        }

        this.userBaseClassMapper.deleteByUserId(userBaseClass);
        this.userRegionMapper.deleteByUserId(userRegion.getUserId());

        String userSource = user.getUserType();
        if (userSource.equals("0")) {// 直销
            user.setAgentId(0);
        }

        this.userMapper.updateByPrimaryKeySelective(user);
        if (userBaseClass.getBaseclassId() != null) {
            this.userBaseClassMapper.insertSelective(userBaseClass);
        }
        if (userRegion.getRegionId() != null) {
            this.userRegionMapper.insertSelective(userRegion);
        }

        return 0;
    }

    @Override
    public Pagination<User> selectMobileByPage(User user) {
        List<User> list = this.userMapper.selectMobileByPage(user);
        return new Pagination<User>(list, user.getPageParameter());
    }

}
