package com.czk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czk.dao.ShirofilterchainMapper;
import com.czk.domain.Shirofilterchain;
import com.czk.domain.ShirofilterchainExample;
@Service
public class FilterChainDefinitionsService {
	@Autowired
    private ShiroFilterFactoryBean shiroFilterFactory;
	@Autowired
	private ShirofilterchainMapper shiroMapper;
	
	
	public Map<String, String> updateFilter(){
		Map<String, String> filterMap = new HashMap<>();
		ShirofilterchainExample example =  new ShirofilterchainExample();
		example.setOrderByClause("sort ASC");
			
		List<Shirofilterchain> list = shiroMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			for(Shirofilterchain filter : list){
				filterMap.put(filter.getUrl(), filter.getPermission());
			}
		}
		/*filterMap.put("/user/login**", "anon");
	    filterMap.put("/admin/**", "anon");//把 admin 设置成不需要拦截
	    filterMap.put(" /super/**", "authc,roles[super],perms[super:info]");*/
	    updatePermission(filterMap);
	
	    return shiroFilterFactory.getFilterChainDefinitionMap();
	}
	
	/**
     * 动态更新新的权限
     * @param filterMap
     */
    private synchronized void updatePermission(Map<String, String> filterMap) {

        AbstractShiroFilter shiroFilter = null;
        try {
            shiroFilter = (AbstractShiroFilter) shiroFilterFactory.getObject();

            // 获取过滤管理器
            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
                    .getFilterChainResolver();
            DefaultFilterChainManager filterManager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            //清空拦截管理器中的存储
            filterManager.getFilterChains().clear();
            /*
            清空拦截工厂中的存储,如果不清空这里,还会把之前的带进去
            ps:如果仅仅是更新的话,可以根据这里的 map 遍历数据修改,重新整理好权限再一起添加
             */
            System.out.println(shiroFilterFactory.getFilterChainDefinitionMap().size());
            
            System.out.println(filterMap.size());
            shiroFilterFactory.getFilterChainDefinitionMap().clear();

            // 相当于新建的 map, 因为已经清空了
            Map<String, String> chains = shiroFilterFactory.getFilterChainDefinitionMap();
            //把修改后的 map 放进去
            chains.putAll(filterMap);

            //这个相当于是全量添加
            for (Map.Entry<String, String> entry : filterMap.entrySet()) {
                //要拦截的地址
                String url = entry.getKey().trim().replace(" ", "");
                //地址持有的权限
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                //生成拦截
                filterManager.createChain(url, chainDefinition);
            }
        } catch (Exception e) {
//            logger.error("updatePermission error,filterMap=" + filterMap, e);
        }
    }

}
