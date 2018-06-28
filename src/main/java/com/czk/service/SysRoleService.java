package com.czk.service;

import java.util.List;

import com.czk.domain.SysRole;

public interface SysRoleService {

	List<SysRole> getRoleList(Long id);

	List<SysRole> getRoleList();

}
