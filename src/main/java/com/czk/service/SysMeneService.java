package com.czk.service;

import java.util.List;

import com.czk.domain.SysMenu;
import com.czk.domain.Tree;

public interface SysMeneService {

	List<Tree<SysMenu>> getSysMenu(Long userId);

}
