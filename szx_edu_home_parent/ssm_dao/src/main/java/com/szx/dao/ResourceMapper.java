package com.szx.dao;


import com.szx.pojo.Resource;
import com.szx.pojo.ResourseVo;

import java.util.List;

public interface ResourceMapper {


    /*（
        资源分页&多条件查询
     */

    public List<Resource> findAllResourceByPage(ResourseVo resourseVo);


}
