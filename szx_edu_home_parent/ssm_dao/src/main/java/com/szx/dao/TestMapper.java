package com.szx.dao;

import com.szx.pojo.Test;

import java.util.List;

public interface TestMapper {
    //插叙test表所有信息
    public List<Test> findAllTest();
}
