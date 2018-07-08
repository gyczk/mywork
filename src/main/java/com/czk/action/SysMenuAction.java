package com.czk.action;

import com.czk.domain.SysMenu;
import com.czk.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 }
