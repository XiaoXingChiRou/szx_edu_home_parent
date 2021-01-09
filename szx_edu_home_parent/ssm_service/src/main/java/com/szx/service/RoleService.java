package com.szx.service;

import com.github.pagehelper.PageInfo;
import com.szx.pojo.Role;
import com.szx.pojo.RoleMenuVo;
import com.szx.pojo.Role_menu_relation;

import java.util.List;

public interface RoleService {

    //查询所有角色 & 条件查询
    public List<Role> findAllRole(Role role);

    //根据角色id查询该角色关联的菜单id
    public List<Integer> findMenuByRoleId(Integer roleId);

    //为角色分配菜单信息
    public void RoleContextMenu(RoleMenuVo roleMenuVo);

    //删除角色
    public void deleteRole(Integer roleId);

}
