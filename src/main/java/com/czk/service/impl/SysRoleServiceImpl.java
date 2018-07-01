package com.czk.service.impl;

import java.util.List;
import java.util.Objects;

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
	
}
