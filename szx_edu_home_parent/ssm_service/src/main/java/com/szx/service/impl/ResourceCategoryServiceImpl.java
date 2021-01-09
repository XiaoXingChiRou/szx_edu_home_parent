package com.szx.service.impl;


import com.szx.dao.ResourceCategoryMapper;
import com.szx.pojo.ResourceCategory;
import com.szx.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;


    @Override
    public List<ResourceCategory> findAllResourceCategory() {

        List<ResourceCategory> allResourceCategory = resourceCategoryMapper.findAllResourceCategory();

        return allResourceCategory;
    }
}
