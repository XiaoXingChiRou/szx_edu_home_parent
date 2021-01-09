package com.szx.controller;

import com.github.pagehelper.PageInfo;
import com.szx.pojo.PromotionAd;
import com.szx.pojo.PromotionAdVO;
import com.szx.pojo.ResponseResult;
import com.szx.service.PromotionAdService;
import com.szx.utils.UploadPictureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    //分页广告查询
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO promotionAdVO){
        PageInfo<PromotionAd> promotionAdByPage = promotionAdService.findAllPromotionAdByPage(promotionAdVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", promotionAdByPage);
        return responseResult;
    }

    //图片上传
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult PromotionAdUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        //调用托片上传方法
        Map<String, String> map = UploadPictureUtils.fileUpload(file, request);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);
        return responseResult;
    }

    //广告上下线
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(Integer id,Integer status){
        promotionAdService.updatePromotionAdStatus(id, status);
        Map<String,Integer> map = new HashMap<>();
        map.put("status",status);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);
        return responseResult;
    }

}
