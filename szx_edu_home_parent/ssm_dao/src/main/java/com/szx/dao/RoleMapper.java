package com.szx.dao;

import com.szx.pojo.Role;
import com.szx.pojo.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    //查询所有角色 & 条件查询
    public List<Role> findAllRole(Role role);

    //根据角色id查询该角色关联的菜单id
    public List<Integer> findMenuByRoleId(Integer roleId);

    //根据roleId清空中间表关联关系
    public void deleteRoleContextMenu(Integer roleId);

    //为角色分配菜单信息
    public void RoleContextMenu(Role_menu_relation role_menu_relation);

    //删除角色
    public void deleteRole(Integer roleId);

}
