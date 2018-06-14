package com.czk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.czk.dao.SysUserMapper;
import com.czk.domain.SysUser;
import com.czk.service.UserService;
import com.czk.utils.Page;
import com.czk.utils.PageUtils;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Override
	public PageUtils<SysUser> getUserList(PageUtils<SysUser> pageUtils, SysUser condition) {
		
		List list = sysUserMapper.getUserListBycondition(condition);
		return null;
	}

	

}
