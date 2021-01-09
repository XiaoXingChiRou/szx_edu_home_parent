package com.szx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szx.dao.RoleMapper;
import com.szx.pojo.Role;
import com.szx.pojo.RoleMenuVo;
import com.szx.pojo.Role_menu_relation;
import com.szx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("/roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    //查询所有角色 & 条件查询
    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> roleList = roleMapper.findAllRole(role);
        return roleList;
    }

    //根据角色id查询该角色关联的菜单id
    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    //为角色分配菜单信息
    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {
        //根据roleId清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());
        Date date = new Date();
        //为角色分配菜单信息
        roleMenuVo.getMenuIdList().forEach(item -> {
            //封装信息
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            //角色id
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());
            //菜单id
            role_menu_relation.setMenuId(item);
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
            roleMapper.RoleContextMenu(role_menu_relation);
        });
    }

    //删除角色
    @Override
    public void deleteRole(Integer roleId) {
        //根据roleId清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleId);
        roleMapper.deleteRole(roleId);
    }
}
