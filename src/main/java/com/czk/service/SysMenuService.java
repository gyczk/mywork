package com.czk.service;

import java.util.List;

import com.czk.domain.SysMenu;
import com.czk.domain.Tree;

public interface SysMenuService {

	List<Tree<SysMenu>> getSysMenu(Long userId);

    List<Tree<SysMenu>> getAllMenu();

    List<Tree<SysMenu>> getAllMenuWithPermission(Long roleId);

    List<SysMenu> getListMenu();
}
