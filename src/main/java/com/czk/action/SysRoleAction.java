package com.czk.action;

import com.czk.domain.*;
import com.czk.service.SysMenuService;
import com.czk.service.SysRoleMenuService;
import com.czk.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.czk.service.SysRoleService;
import com.czk.utils.PageUtils;

import java.util.List;

@Controller
@RequestMapping("/sys/role")
public class SysRoleAction {
	
	@Autowired
	SysRoleService sysRoleService;

	@Autowired
	SysMenuService sysMenuService;
	@Autowired
	SysRoleMenuService sysRoleMenuService;

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
		List<Tree<SysMenu>> menus = sysMenuService.getAllMenu();
		return menus;
	}
	@PostMapping("/getAllMenuWithPermission")
	@ResponseBody
	public List<Tree<SysMenu>> getAllMenuWithPermission(Long roleId){
		List<Tree<SysMenu>> menus = sysMenuService.getAllMenuWithPermission(roleId);
		return menus;
	}



	@PostMapping("/add")
	@ResponseBody
	public R add(SysRoleVo sysRoleVo){
		boolean flag = sysRoleService.addRole(sysRoleVo);
		if(flag){
			return R.ok();

		}
		return R.error();
	}

	@GetMapping("/edit_page/{roleId}")
	public String edit_page(@PathVariable("roleId")Long id,Model model){
		SysRole role = sysRoleService.getRoleByRoleId(id);
		model.addAttribute("role",role);
		return "role/edit";

	}

	@PostMapping("/update")
	@ResponseBody
	public R update(SysRoleVo roleVo){
		boolean flag =sysRoleService .update(roleVo);
		if(flag){
			return R.ok();
		}
		return R.error();
	}
}
