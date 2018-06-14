package com.czk.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czk.domain.SysUser;
import com.czk.service.UserService;
import com.czk.utils.Page;
import com.czk.utils.PageUtils;
import com.czk.utils.Query;

@Controller
@RequestMapping("/sys/user")
public class UserAction {
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String userManage(){
		
		return "user/list";
	}
	
	@PostMapping("/list")
	@ResponseBody
	public PageUtils userList(PageUtils pageUtils,SysUser condition){
		pageUtils = userService.getUserList(pageUtils,condition);
		return null;
		
	}
}
