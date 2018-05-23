package com.czk.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.czk.dao.ShirofilterchainMapper;
import com.czk.domain.Shirofilterchain;
import com.czk.domain.ShirofilterchainExample;

public class FilterChainDefinitionMapBuilder {
	@Autowired
	private ShirofilterchainMapper shiroMapper;
	
	public Map<String,String>  buildFilterChainDefinitionMap(){
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
		ShirofilterchainExample example =  new ShirofilterchainExample();
		example.setOrderByClause("sort ASC");
			
		List<Shirofilterchain> list = shiroMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			for(Shirofilterchain filter : list){
				System.out.println(filter.getUrl());
				filterChainDefinitionMap.put(filter.getUrl(), filter.getPermission());
			}
		}
		
		/*
		/css/** = anon
		/js/** = anon
		/images/** = anon
		/login.jsp = anon
		/validatecode.jsp* = anon
		/userAction_login.action = anon
		/page_base_staff.action = perms["staff1"]
		/* = authc
		 */
		
		/*filterChainDefinitionMap.put("/css/**","anon");
		filterChainDefinitionMap.put("/images/**","anon");
		filterChainDefinitionMap.put("/js/**","anon");
		filterChainDefinitionMap.put("/login.action","anon");
		filterChainDefinitionMap.put("/customer/findAll.action","perms[customer:findAll]");
		filterChainDefinitionMap.put("/**","authc");*/
		
		return filterChainDefinitionMap;
	}
}
