package com.szx.dao;

import com.szx.pojo.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    //分页广告查询
    public List<PromotionAd> findAllPromotionAdByPage();

    //广告上下线
    public void updatePromotionAdStatus(PromotionAd promotionAd);

}
