package com.szx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szx.dao.PromotionAdMapper;
import com.szx.pojo.PromotionAd;
import com.szx.pojo.PromotionAdVO;
import com.szx.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("/promotionAdService")
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    //分页广告查询
    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {
        //添加分页查询信息
        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());
        List<PromotionAd> allPromotionAdByPage = promotionAdMapper.findAllPromotionAdByPage();
        //将查询结果封装到PageInfo
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAdByPage);
        return pageInfo;
    }

    //广告上下线
    @Override
    public void updatePromotionAdStatus(Integer id,Integer status) {
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }


}
