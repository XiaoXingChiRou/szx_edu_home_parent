package com.szx.service.impl;

import com.szx.dao.TestMapper;
import com.szx.pojo.Test;
import com.szx.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//具体业务实现类
@Service("testService")     //注入到容器，并命名
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    //查询test表中所有数据
    @Override
    public List<Test> findAllTest() {
        return testMapper.findAllTest();
    }

}
