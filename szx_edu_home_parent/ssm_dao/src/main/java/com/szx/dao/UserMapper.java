package com.szx.dao;

import com.szx.pojo.User;
import com.szx.pojo.UserVo;

import java.util.List;

public interface UserMapper {

    //用户分页&多条件组合查询
    public List<User> findAllUserByPage(UserVo userVo);

}
