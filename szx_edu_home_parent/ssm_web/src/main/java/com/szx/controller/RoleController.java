package com.szx.controller;

import com.szx.pojo.*;
import com.szx.service.MenuService;
import com.szx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    //查询所有角色 & 条件查询
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> roleList = roleService.findAllRole(role);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", roleList);
        return responseResult;
    }

    //查询所有父子菜单信息
    @RequestMapping("/findAllMenu")
    public ResponseResult findMenuInfoById(){
        // -1 表示查询所有的父子级菜单
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);
        Map<String,Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);
        return responseResult;
    }

    //根据角色id查询该角色关联的菜单id
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", menuByRoleId);
        return responseResult;
    }

    //为角色分配菜单信息
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.RoleContextMenu(roleMenuVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", null);
        return responseResult;
    }

    //删除角色
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", null);
        return responseResult;
    }

}
