package com.czk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.SysUserMapper;
import com.czk.domain.SysUser;
import com.czk.domain.SysUserExample;
import com.czk.domain.SysUserExample.Criteria;
import com.czk.service.UserService;
import com.czk.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SysUserMapper sysUserMapper;
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
	public int addUser(SysUser user) {
		int count = sysUserMapper.insert(user);
		return count;
	}

	@Override
	public SysUser getUserByUserId(Long id) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public int update(SysUser user) {
		int count = sysUserMapper.updateByPrimaryKey(user);
		return count;
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
	
	

	

}
