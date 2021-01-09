package com.szx.service;

import com.github.pagehelper.PageInfo;
import com.szx.pojo.User;
import com.szx.pojo.UserVo;

import java.util.List;

public interface UserService {

    //用户分页&多条件组合查询
    public PageInfo<User> findAllUserByPage(UserVo userVo);

}
