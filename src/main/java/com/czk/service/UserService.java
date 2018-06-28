package com.czk.service;

import java.util.Map;

import com.czk.domain.SysUser;
import com.czk.domain.SysUserVo;
import com.czk.utils.Page;
import com.czk.utils.PageUtils;

public interface UserService {

	PageUtils<SysUser> getUserList(PageUtils<SysUser> pageUtils, SysUser condition);

	boolean isExist(String username);

	boolean addUser(SysUserVo userVo);

	SysUser getUserByUserId(Long id);

	boolean update(SysUserVo userVo);

	int batchDel(Long[] ids);

	int del(Long id);

	int adminUpdatePwd(SysUser user) throws Exception;

	

}
