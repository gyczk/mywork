package com.czk.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.czk.dao.SysRoleMenuMapper;
import com.czk.domain.SysRoleMenu;
import com.czk.domain.SysRoleMenuExample;
import com.czk.domain.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.SysRoleMapper;
import com.czk.dao.SysUserRoleMapper;
import com.czk.domain.SysRole;
import com.czk.service.SysRoleService;
import com.czk.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper userRoleMapper;

	@Autowired
	private SysRoleMenuMapper rolemenuMapper;
	@Override
	public List<SysRole> getRoleList(Long id) {
		List<SysRole> list = sysRoleMapper.selectByExample(null);
		List<Long> ids = userRoleMapper.getRoleIdByUserId(id);
		for(SysRole sysRole :list){
			sysRole.setRoleSign("false");
			for(Long roleId:ids){
				if(Objects.deepEquals(sysRole.getRoleId(),roleId)){
					sysRole.setRoleSign("true");
				}
			}
		}
		
		return list;
	}
	@Override
	public List<SysRole> getRoleList() {
		return sysRoleMapper.selectByExample(null);
	}
	@Override
	public PageUtils<SysRole> getRoleList(PageUtils<SysRole> pageUtils, SysRole condition) {
		PageHelper.startPage(pageUtils.getOffset(), pageUtils.getLimit());
		List<SysRole> list = sysRoleMapper.getRoleListByCondition(condition);
		PageInfo<SysRole> pageInfo = new PageInfo<>(list);
		pageUtils.setRows(list);
		pageUtils.setTotal((int) pageInfo.getTotal());
		return pageUtils;
	}

	@Override
	public boolean addRole(SysRoleVo sysRoleVo) {
		SysRole sysRole = sysRoleVo.getSysRole();
		int roleCount = sysRoleMapper.insert(sysRole);
		Long roleId = sysRole.getRoleId();
		List<SysRoleMenu> list = new ArrayList<>();
		List<Long> menuIds = sysRoleVo.getMenuIds();
		for(Long menuId:menuIds){
			SysRoleMenu roleMenu = new SysRoleMenu();
			roleMenu.setRoleId(roleId);
			roleMenu.setMenuId(menuId);
			list.add(roleMenu);
		}
		int roleMenucount = 0;
		if(list.size()>0){
			roleMenucount = rolemenuMapper.batachInsert(list);
		}
		if(roleCount>0&&roleMenucount>=0){
			return true;
		}


		return false;
	}

	@Override
	public SysRole getRoleByRoleId(Long id) {
		SysRole role = sysRoleMapper.selectByPrimaryKey(id);
		return role;
	}

	@Override
	public boolean update(SysRoleVo roleVo) {
		int roleCount = sysRoleMapper.updateByPrimaryKey(roleVo.getSysRole());
		Long roleId = roleVo.getSysRole().getRoleId();
		//先删除原有的角色菜单关联数据
		SysRoleMenuExample example = new SysRoleMenuExample();
		SysRoleMenuExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		rolemenuMapper.deleteByExample(example);

		List<SysRoleMenu> list = new ArrayList<>();
		List<Long>  menuIds = roleVo.getMenuIds();
		for(Long menuId:menuIds){
			SysRoleMenu menu = new SysRoleMenu();
			menu.setRoleId(roleId);
			menu.setMenuId(menuId);
			list.add(menu);
		}
		int menuCount = 0;
		if(list.size()>0){
			menuCount = rolemenuMapper.batachInsert(list);
		}
		if(roleCount>0&&menuCount>=0){
			return true;
		}
		return false;
	}

}
