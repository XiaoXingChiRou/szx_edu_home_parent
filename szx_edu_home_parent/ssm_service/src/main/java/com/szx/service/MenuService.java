package com.szx.service;

import com.szx.pojo.Menu;

import java.util.List;

public interface MenuService {

    //查询所有父子菜单信息
    public List<Menu> findSubMenuListByPid(Integer pid);

    //查询所有菜单信息
    public List<Menu> findAllMenu();

    //回显所有menu信息
    public Menu findMenuById(Integer id);
}
