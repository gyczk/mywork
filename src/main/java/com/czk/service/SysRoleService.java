package com.czk.service;

import java.util.List;

import com.czk.domain.SysRole;
import com.czk.utils.PageUtils;

public interface SysRoleService {

	List<SysRole> getRoleList(Long id);

	List<SysRole> getRoleList();

	PageUtils<SysRole> getRoleList(PageUtils<SysRole> pageUtils, SysRole condition);

}
