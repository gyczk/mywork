package com.czk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.SysUserMapper;
import com.czk.dao.SysUserRoleMapper;
import com.czk.domain.SysUser;
import com.czk.domain.SysUserExample;
import com.czk.domain.SysUserExample.Criteria;
import com.czk.domain.SysUserRole;
import com.czk.domain.SysUserRoleExample;
import com.czk.domain.SysUserVo;
import com.czk.service.UserService;
import com.czk.utils.PageUtils;
import com.czk.utils.UserUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public PageUtils<SysUser> getUserList(PageUtils<SysUser> pageUtils, SysUser condition) {
		PageHelper.startPage(pageUtils.getOffset(), pageUtils.getLimit());
		List<SysUser> list = sysUserMapper.getUserListBycondition(condition);
		PageInfo<SysUser> pageInfo = new PageInfo<>(list);
		pageUtils.setRows(list);
		pageUtils.setTotal((int) pageInfo.getTotal());
		return pageUtils;
	}
	
	@Override
	public boolean isExist(String username) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addUser(SysUserVo userVo) {
		int userCount = sysUserMapper.insert(userVo.getSysUser());
		Long userId = userVo.getSysUser().getUserId();
		List<SysUserRole> list = new ArrayList<>();
		List<Long> roleIds = userVo.getRoleIds();
		for(Long roleId: roleIds){
			SysUserRole role = new SysUserRole();
			role.setUserId(userId);
			role.setRoleId(roleId);
			list.add(role);
		}
		int roleCount=0;
		if(list.size()>0){
			 roleCount =sysUserRoleMapper.batachInsert(list);
		}
		
		
		if(userCount>0&&roleCount>=0){
			return true;
		}
		
		
		return false;
	}

	@Override
	public SysUser getUserByUserId(Long id) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public boolean update(SysUserVo userVo) {
		int userCount = sysUserMapper.updateByPrimaryKey(userVo.getSysUser());
		Long userId = userVo.getSysUser().getUserId();
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		sysUserRoleMapper.deleteByExample(example);
		
		List<SysUserRole> list = new ArrayList<>();
		List<Long> roleIds = userVo.getRoleIds();
		for(Long roleId: roleIds){
			SysUserRole role = new SysUserRole();
			role.setUserId(userId);
			role.setRoleId(roleId);
			list.add(role);
		}
		int roleCount=0;
		if(list.size()>0){
			 roleCount =sysUserRoleMapper.batachInsert(list);
		}
		
		
		if(userCount>0&&roleCount>=0){
			return true;
		}
		
		
		return false;
	}

	@Override
	public int batchDel(Long[] ids) {
		int count = sysUserMapper.batchDel(ids);
		return count;
	}

	@Override
	public int del(Long id) {
		return sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int adminUpdatePwd(SysUser user) throws Exception {
		SysUser loginUser = UserUtils.getLoginUser();
		if("admin".equals(loginUser.getUsername())){
			throw new Exception("超级管理员的账号不允许直接重置"); 
		}
		Long userId = user.getUserId();
		String password = user.getPassword();
		int count = sysUserMapper.updatePwd(userId,password); 
		return count;
	}
	
	

	

}
