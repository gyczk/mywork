package com.czk.service;

import java.util.List;

public interface SysRoleMenuService {
    List<Long> getAllMenuIdByRoleId(Long roleId);
}
