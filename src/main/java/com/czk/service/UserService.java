package com.czk.service;

import java.util.Map;

import com.czk.domain.SysUser;
import com.czk.utils.Page;
import com.czk.utils.PageUtils;

public interface UserService {

	PageUtils<SysUser> getUserList(PageUtils<SysUser> pageUtils, SysUser condition);

	

}
