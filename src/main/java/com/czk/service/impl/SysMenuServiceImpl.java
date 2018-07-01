package com.czk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.SysMenuMapper;
import com.czk.domain.SysMenu;
import com.czk.domain.Tree;
import com.czk.service.SysMeneService;
@Service
public class SysMenuServiceImpl implements SysMeneService {
	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Override
	public  List<Tree<SysMenu>> getSysMenu(Long userId) {
		List<SysMenu> menus = sysMenuMapper.getMenuListByUserId(userId);//查询左侧系统菜单
		//提取公共方法
		//组装数据
		List<Tree<SysMenu>> trees = getDataTreeList(menus);
		List<Tree<SysMenu>> menuList = buildListTree(trees,"0");
		return menuList;
	}

	private List<Tree<SysMenu>> getDataTreeList(List<SysMenu> menus) {
		List<Tree<SysMenu>> trees = new ArrayList<>();
		for(SysMenu sysmenu :menus){
			Tree<SysMenu> tree = new Tree<SysMenu>();
			tree.setId(sysmenu.getMenuId());
			tree.setParentId(sysmenu.getParentId());
			tree.setText(sysmenu.getName());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url",sysmenu.getUrl());
			attributes.put("icon",sysmenu.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		return trees;
	}

	@Override
	public List<Tree<SysMenu>> getAllMenu() {
		List<SysMenu> menus = sysMenuMapper.selectByExample(null);
		List<Tree<SysMenu>> trees = getDataTreeList(menus);
		List<Tree<SysMenu>> menuList = buildListTree(trees,"0");
		//添加顶级菜单
		List<Tree<SysMenu>> allMenuList = new ArrayList<Tree<SysMenu>>();
		Tree<SysMenu> tree = new Tree<SysMenu>();
		tree.setText("顶级节点");
		tree.setId(-1L);
		tree.setChildren(menuList);
		allMenuList.add(tree);


		return allMenuList;
	}

	private  List<Tree<SysMenu>> buildListTree(List<Tree<SysMenu>> trees, String rootId) {
		if(trees==null){
			return null;
		}
		List<Tree<SysMenu>> topNodes = new ArrayList<Tree<SysMenu>>();
		for(Tree<SysMenu> children :trees){
			Long pid = children.getParentId();
			if(pid==null||rootId.equals(pid+"")){
				topNodes.add((Tree<SysMenu>) children);
				continue;
			}
			
			for(Tree<SysMenu> parent :trees){
				Long id = parent.getId();
				if(id!=null&&id.equals(pid)){
					parent.getChildren().add(children);
					children.setHasParent(true);
					parent.setChildren(true);
					continue;
				}
				
			}
		}
		return topNodes;
	}

}
