package com.szx.controller;

import com.github.pagehelper.PageInfo;
import com.szx.pojo.Resource;
import com.szx.pojo.ResourseVo;
import com.szx.pojo.ResponseResult;
import com.szx.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    public ResourceService resourceService;

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResourceByPage( ResourseVo resourseVo){

        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourseVo);

        return  new ResponseResult(true,200,"资源信息分页多条件查询成功",pageInfo);

    }



}
