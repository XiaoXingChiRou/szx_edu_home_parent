package com.szx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.szx.dao.ResourceMapper;
import com.szx.pojo.Resource;
import com.szx.pojo.ResourseVo;
import com.szx.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;


    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourseVo resourseVo) {

        //分页查询
        PageHelper.startPage(resourseVo.getCurrentPage(),resourseVo.getPageSize());

        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourseVo);

        PageInfo<Resource> pageInfo = new PageInfo<>(allResourceByPage);

        return pageInfo;
    }
}
