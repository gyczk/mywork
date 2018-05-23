package com.czk.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.czk.domain.SysFile;
import com.czk.domain.SysUser;
import com.czk.service.SysFileService;
import com.czk.service.impl.FilterChainDefinitionsService;


@Controller
public class SystemAction {
	
	@Autowired
	private FilterChainDefinitionsService filterService;
	
	@Autowired
	private SysFileService fileService;
	
	@GetMapping("/login")
	public String index(@ModelAttribute("msg") String error, Model model){
		if(StringUtils.isNotBlank(error)){
			model.addAttribute("error", error);
		}
		return "login";
	}
	
	@PostMapping("/login")
	public String login(SysUser user,HttpSession session,RedirectAttributes model){
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try {
			subject.login(token);
			SysUser lgoinUser =  (SysUser) subject.getPrincipal();
			session.setAttribute("user", lgoinUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addFlashAttribute("msg", "用户名密码错误");
			return "redirect:/login";
		}
		return "redirect:/index";
	}
	
	@GetMapping({ "/index" })
	public String index(Model model,HttpServletRequest request) {
		/*List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());*/
		SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		SysFile sysFile = fileService.get(sysUser.getPicId());
		if(sysFile!=null&&sysFile.getUrl()!=null){
			if(fileService.isExist(sysFile.getUrl())){
				model.addAttribute("picUrl",request.getContextPath()+sysFile.getUrl());
			}else {
				model.addAttribute("picUrl","/img/photo_s.jpg");
			}
		}else {
			model.addAttribute("picUrl","/img/photo_s.jpg");
		}
		model.addAttribute("username", sysUser.getUsername());
		return "index_v1";
	}
	
	@PostMapping("/login_old")
	public String login_old(SysUser user,HttpSession session,RedirectAttributes model){
		System.out.println(user.getUsername()+"------"+user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try {
			subject.login(token);
			SysUser lgoinUser =  (SysUser) subject.getPrincipal();
			session.setAttribute("user", lgoinUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addFlashAttribute("msg", "用户名密码错误");
			return "redirect:/login";
		}
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/toHome")  
    public String home(@ModelAttribute("error") String error, Model model) {  
        System.out.println("拿到重定向得到的参数msg:" + error);  
        model.addAttribute("error", error);  
        return "redirect:/login";  
    }  
	@ResponseBody
	@GetMapping("/updateShiroFilter")
	public void updateShiroFilter(){
		filterService.updateFilter();
	}
	
	@RequestMapping("/logout")  
    public String logout() {  
		
		SecurityUtils.getSubject().logout();
        return "login";  
    }  
	
	@RequestMapping("/error") 
	public String error(){
		return "/error";
	}
	
}
