package com.szx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szx.dao.UserMapper;
import com.szx.pojo.User;
import com.szx.pojo.UserVo;
import com.szx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //用户分页&多条件组合查询
    @Override
    public PageInfo<User> findAllUserByPage(UserVo userVo) {
        //设置查询页数及显示数量
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> userList = userMapper.findAllUserByPage(userVo);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

}
