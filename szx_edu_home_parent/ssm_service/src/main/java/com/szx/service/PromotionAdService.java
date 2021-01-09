package com.szx.service;

import com.github.pagehelper.PageInfo;
import com.szx.pojo.PromotionAd;
import com.szx.pojo.PromotionAdVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PromotionAdService {

    //分页广告查询
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    //广告上下线
    public void updatePromotionAdStatus(Integer id,Integer status);

}
