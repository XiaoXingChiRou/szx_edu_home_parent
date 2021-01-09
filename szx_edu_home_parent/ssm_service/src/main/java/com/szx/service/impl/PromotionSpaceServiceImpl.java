package com.szx.service.impl;

import com.szx.dao.PromotionSpaceMapper;
import com.szx.pojo.PromotionSpace;
import com.szx.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("promotionSpaceService")
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    //查询所有广告位
    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    //添加广告位
    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        //补全信息
        Date date = new Date();
        //随机值
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    //回显广告位名称
    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }

    //修改广告位
    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        //补全信息
        promotionSpace.setUpdateTime(new Date());
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
