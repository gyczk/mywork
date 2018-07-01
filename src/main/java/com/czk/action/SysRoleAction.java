package com.czk.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czk.domain.SysRole;
import com.czk.service.SysRoleService;
import com.czk.utils.PageUtils;

@Controller
@RequestMapping("/sys/role")
public class SysRoleAction {
	
	@Autowired SysRoleService sysRoleService;
	
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
}
