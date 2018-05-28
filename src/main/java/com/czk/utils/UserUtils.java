package com.czk.utils;

import org.apache.shiro.SecurityUtils;

import com.czk.domain.SysUser;

public class UserUtils {
	public static SysUser getLoginUser(){
		SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}
}
