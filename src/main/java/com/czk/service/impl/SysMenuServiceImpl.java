package com.czk.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.czk.dao.SysRoleMenuMapper;
import com.czk.domain.SysRoleMenuExample;
import com.czk.service.SysRoleMenuService;
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

	@Autowired
	private SysRoleMenuService sysRoleMenuService;
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
		Map<String, Object> state = new HashMap<>(16);
		state.put("opened", true);
		tree.setState(state);
		tree.setChildren(menuList);
		allMenuList.add(tree);


		return allMenuList;
	}

	@Override
	public List<Tree<SysMenu>> getAllMenuWithPermission(Long roleId) {
		//获取角色id对应的权限id
		List<Long> menuIds= sysRoleMenuService.getAllMenuIdByRoleId(roleId);
		List<Tree<SysMenu>> allMenu = getAllMenu();
		//递归设置选中状态
		setChecked(allMenu,menuIds);
		/*for(Tree<SysMenu> tree : allMenu){
			setChecked();
		}*/


		return allMenu;
	}

	private void setChecked(List<Tree<SysMenu>> allMenu, List<Long> menuIds) {
		for(Tree<SysMenu> tree:allMenu){
			if(tree.getChildren().size()>0){
				setChecked(tree.getChildren(),menuIds);
			}else{
				if(menuIds.contains(tree.getId())){
					Map<String, Object> state = new HashMap<>(16);
					state.put("selected", true);
					tree.setState(state);
				}
			}
		}

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
