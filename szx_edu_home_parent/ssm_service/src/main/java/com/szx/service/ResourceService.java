package com.szx.service;

import com.github.pagehelper.PageInfo;
import com.szx.pojo.Resource;
import com.szx.pojo.ResourseVo;


public interface ResourceService {

   /*（
        资源分页&多条件查询
     */

    public PageInfo<Resource> findAllResourceByPage(ResourseVo resourseVo);


}
