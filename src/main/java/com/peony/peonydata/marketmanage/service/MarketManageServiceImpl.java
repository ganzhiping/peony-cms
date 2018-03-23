package com.peony.peonydata.marketmanage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.seller.dao.SellerMapper;
import com.peony.peonydata.seller.model.Seller;
import com.peony.peonydata.user.dao.UserMapper;
import com.peony.peonydata.user.model.User;

/**
 * 市场人员管理服务接口
 *
 * @author jhj
 */
@Service
public class MarketManageServiceImpl implements MarketManageService {
    @Resource
    private UserMapper   userMapper;   // 用户mapper

    @Resource
    private SellerMapper sellerMapper; // 销售人员管理关系mapper

    @Override
    public Pagination<User> selectByPage(User record) {
        List<User> list = this.userMapper.selectByPage(record);
        return new Pagination<User>(list, record.getPageParameter());
    }

    @Override
    public int insertMarketUser(User record, Seller seller) {
        this.userMapper.insertSelective(record);
        this.sellerMapper.insertSelective(seller);
        return 0;
    }

}
