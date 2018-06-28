package com.czk.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czk.domain.SysRole;
import com.czk.domain.SysUser;
import com.czk.domain.SysUserVo;
import com.czk.service.SysRoleService;
import com.czk.service.UserService;
import com.czk.utils.PageUtils;
import com.czk.utils.R;

@Controller
@RequestMapping("/sys/user")
public class UserAction {
	@Autowired
	private UserService userService;
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@GetMapping("")
	public String userManage(){
		
		return "user/list";
	}
	
	@GetMapping("/add_page")
	public String add_page(){
		
		return "user/add";
	}
	
	
	@PostMapping("/list")
	@ResponseBody
	public PageUtils<SysUser> userList(PageUtils<SysUser> pageUtils,SysUser condition){
		pageUtils = userService.getUserList(pageUtils,condition);
		return pageUtils;
		
	}
	
	@PostMapping("/isExist")
	@ResponseBody
	public String isExit(@RequestParam("username")String username){
		boolean  flag = userService.isExist(username);
		if(flag){
			return "false";
		}
		return "true";
		
	}
	
	@PostMapping("/add")
	@ResponseBody
	public R add(SysUser user){
		int count = userService.addUser(user);
		if(count>0){
			return R.ok();
		}
		return R.error();
		
	}
	
	@GetMapping("/edit_page/{userId}")
	public String edit_page(@PathVariable("userId")Long id,Model model){
		SysUser user = userService.getUserByUserId(id);
		List<SysRole> roleList = sysRoleService.getRoleList(id);
		model.addAttribute("user",user);
		model.addAttribute("roles",roleList);
		return "user/edit";
		
	}
	
	@PostMapping("/update")
	@ResponseBody
	public R update(SysUserVo userVo){
		SysUser user = userVo.getSysUser();
		int count = userService.update(user);
		if(count>0){
			return R.ok();
		}
		return R.error();
	}
	
	@PostMapping("/batchDel")
	@ResponseBody
	public R batchDel(@RequestParam("ids[]")Long[] ids){
		int count = userService.batchDel(ids);
		if(count>0){
			return R.ok("删除成功");
		}
		return R.error("删除失败");
	}
	
	@PostMapping("/del")
	@ResponseBody
	public R del(@RequestParam("id")Long id){
		int count = userService.del(id);
		if(count>0){
			return R.ok("删除成功");
		}
		return R.error("删除失败");
	}
	@GetMapping("/restPwd/{userId}")
	public String restPwd(@PathVariable("userId")Long id,Model model){
		SysUser user = userService.getUserByUserId(id);
		model.addAttribute("user",user);
		return "user/resetPwd";
		
	}
	@PostMapping("/adminUpdatePwd")
	public R updatePwd(SysUser user){
		try {
			int count = userService.adminUpdatePwd(user);
			if(count>0){
				return R.ok();
			}
		} catch (Exception e) {
			return R.error(1,e.getMessage());
		}
		return R.error();
		
	}
	
}
