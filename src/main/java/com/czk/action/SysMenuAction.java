package com.czk.action;

import com.czk.domain.SysMenu;
import com.czk.service.SysMenuService;
import com.czk.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sys/menu")
public class SysMenuAction {

    @Autowired
    private SysMenuService sysMenuService;
    @GetMapping("")
    public String menuManage(){
        return "menu/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public List<SysMenu> menuList(){
        List<SysMenu> list = sysMenuService.getListMenu();
        return list;
    }

    @GetMapping("/add_page/{pid}")
    public String add_page(@PathVariable("pid")Long pid, Model model){
        model.addAttribute("pId",pid);
        if(0==pid){
            model.addAttribute("pName","根目录");
        }else{
            model.addAttribute("pName",sysMenuService.getMenuById(pid).getName());
        }

        return "menu/add";
    }
    @GetMapping("/edit_page/{id}")
    public String edit_page(@PathVariable("id")Long id, Model model){
        SysMenu sysMenu = sysMenuService.getMenuById(id);
        Long pid = sysMenu.getParentId();
        model.addAttribute("pId",pid);
        if(0==pid){
            model.addAttribute("pName","根目录");
        }else {
            model.addAttribute("pName",sysMenuService.getMenuById(pid).getName());
        }
        model.addAttribute("sysMenu",sysMenu);
        return "/menu/edit";
    }



    @PostMapping("/add")
    @ResponseBody
    public R add(SysMenu sysMenu){
        int count = sysMenuService.save(sysMenu);
        if(count>0) {
            return R.ok();
        }
        return  R.error();
    }

    @PostMapping("/update")
    @ResponseBody
    public R update(SysMenu sysMenu){
        int count = sysMenuService.update(sysMenu);
        if(count>0) {
            return R.ok();
        }
        return  R.error();
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public R del(@PathVariable("id")Long id){
        int count = sysMenuService.del(id);
        if(count>0) {
            return R.ok();
        }
        return  R.error();
    }
 }
