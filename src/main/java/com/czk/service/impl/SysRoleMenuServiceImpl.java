package com.czk.service.impl;

import com.czk.dao.SysRoleMenuMapper;
import com.czk.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;
    @Override
    public List<Long> getAllMenuIdByRoleId(Long roleId) {
        List<Long> menuIds = sysRoleMenuMapper.getMenuIDByRoleId(roleId);
        return menuIds;
    }
}
