package com.szx.controller;

import com.szx.pojo.PromotionSpace;
import com.szx.pojo.ResponseResult;
import com.szx.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    //查询所有广告位
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> list = promotionSpaceService.findAllPromotionSpace();
        //封装返回信息
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", list);
        return responseResult;
    }

    //添加 & 更新广告位
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){
        if (promotionSpace.getId() == null){
            //新增广告位
            promotionSpaceService.savePromotionSpace(promotionSpace);
            //封装返回信息
            ResponseResult responseResult = new ResponseResult(true, 200, "新增成功", null);
            return responseResult;
        } else {
            //修改广告位
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            //封装返回信息
            ResponseResult responseResult = new ResponseResult(true, 200, "修改成功", null);
            return responseResult;
        }
    }

    //回显广告位名称
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(Integer id){
        PromotionSpace promotionSpaceById = promotionSpaceService.findPromotionSpaceById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", promotionSpaceById);
        return responseResult;
    }

}
