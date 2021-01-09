package com.szx.service.impl;

import com.szx.dao.MenuMapper;
import com.szx.pojo.Menu;
import com.szx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    //查询所有父子菜单信息
    @Override
    public List<Menu> findSubMenuListByPid(Integer pid) {
        return menuMapper.findSubMenuListByPid(pid);
    }

    //查询所有菜单信息
    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    //回显所有menu信息
    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }
}
