package com.szx.controller;

import com.github.pagehelper.PageInfo;
import com.szx.pojo.ResponseResult;
import com.szx.pojo.User;
import com.szx.pojo.UserVo;
import com.szx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户分页&多条件组合查询
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){
        PageInfo<User> userPageInfo = userService.findAllUserByPage(userVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", userPageInfo);
        return responseResult;
    }

}
