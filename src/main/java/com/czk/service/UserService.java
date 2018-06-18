package com.czk.service;

import java.util.Map;

import com.czk.domain.SysUser;
import com.czk.utils.Page;
import com.czk.utils.PageUtils;

public interface UserService {

	PageUtils<SysUser> getUserList(PageUtils<SysUser> pageUtils, SysUser condition);

	boolean isExist(String username);

	int addUser(SysUser user);

	SysUser getUserByUserId(Long id);

	int update(SysUser user);

	int batchDel(Long[] ids);

	int del(Long id);

	int adminUpdatePwd(SysUser user) throws Exception;

	

}
