package com.czk.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.czk.domain.SysUser;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
			
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String[] allowUrls = new String[]{"/login.action","/logout.action"};
		
		String url = request.getRequestURL().toString();
		
		SysUser user = (SysUser) session.getAttribute("user");
		
		for(String allowUrl :allowUrls){
			if(url.contains(allowUrl)){
				return true;
			}
		}
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/login.action"); 
		}
		
		return true;
	}

}
