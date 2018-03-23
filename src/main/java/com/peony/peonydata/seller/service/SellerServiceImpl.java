package com.peony.peonydata.seller.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.seller.dao.SellerMapper;
import com.peony.peonydata.seller.model.Seller;

/**
 * 市场人员管理关系服务
 * @author jhj
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Resource
    private SellerMapper sellerMapper; // 市场人员管理关系mapper

    @Override
    public List<Seller> selectByManagerId(Seller record) {
        return this.sellerMapper.selectByManagerId(record);
    }

    @Override
    public int updateSeller(Seller record) {
        if(record!=null){
            int managerUserId=record.getManagerUserId();
            String userIds=record.getUserIds();
            String [] arrayUserId=userIds.split(",");
            if(userIds!=null && !"".equals(userIds)&& managerUserId>0){
                this.sellerMapper.deleteByManagerUserId(managerUserId);
                //save
                for(String userId:arrayUserId){
                    Seller seller=new Seller();
                    seller.setManagerUserId(managerUserId);
                    seller.setUserId(Integer.valueOf(userId));
                    this.sellerMapper.insert(seller);
                }

            }else{
                this.sellerMapper.deleteByManagerUserId(managerUserId);
            }

        }



        return 0;
    }


}
