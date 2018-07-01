package com.czk.action;

import com.czk.domain.SysMenu;
import com.czk.domain.Tree;
import com.czk.service.SysMeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.czk.domain.SysRole;
import com.czk.service.SysRoleService;
import com.czk.utils.PageUtils;

import java.util.List;

@Controller
@RequestMapping("/sys/role")
public class SysRoleAction {
	
	@Autowired
	SysRoleService sysRoleService;

	@Autowired
	SysMeneService sysMeneService;

	@GetMapping("")
	public String roleManage(){
		return "role/list";
	}
	
	@PostMapping("/list")
	@ResponseBody
	public PageUtils<SysRole> roleList(PageUtils<SysRole> pageUtils,SysRole condition){
		pageUtils = sysRoleService.getRoleList(pageUtils,condition);
		return pageUtils;
	}

	@GetMapping("/add_page")
	public String add_page(){
		return "role/add";
	}

	@PostMapping("/getAllMenu")
	@ResponseBody
	public List<Tree<SysMenu>> getAllMenu(){
		List<Tree<SysMenu>> menus = sysMeneService.getAllMenu();
		return menus;
	}
}
