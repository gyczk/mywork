package com.czk.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.czk.dao.SysMenuMapper;
import com.czk.dao.SysUserMapper;
import com.czk.domain.SysMenu;
import com.czk.domain.SysMenuExample;
import com.czk.domain.SysUser;
import com.czk.domain.SysUserExample;

public class MyWorkRealm extends AuthorizingRealm{
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	//授权方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
//		User user2 = (User) SecurityUtils.getSubject().getPrincipal();
//		System.out.println(user1==user2);
		List<SysMenu> list = null;
		if(user.getUsername().equals("admin")){
			SysMenuExample example = new SysMenuExample();
			list = sysMenuMapper.selectByExample(example);
		}else{
			list = sysMenuMapper.selectMenuList(user.getUserId());
		}
		for(SysMenu sysMenu : list){
			if(StringUtils.isNotBlank(sysMenu.getPerms())){
				info.addStringPermission(sysMenu.getPerms());
			}
			
		}
		return info;
	}

	@Override
	//认证方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken mytoken = (UsernamePasswordToken) token;
		String userName = mytoken.getUsername();
		SysUserExample example = new SysUserExample();
		com.czk.domain.SysUserExample.Criteria criteria =  example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		
		List<SysUser> list =  sysUserMapper.selectByExample(example);
		if(list==null||list.size()<=0){
			return null;
		}
		SysUser user = list.get(0);
		
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
		
	}

}
