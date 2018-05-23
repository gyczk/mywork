package com.czk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver{
	private String defaultErrorView;
	
	public void setDefaultErrorView(String defaultErrorView) {
		this.defaultErrorView = defaultErrorView;
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse, Object paramObject, Exception paramException) {
		paramException.printStackTrace();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", paramException);
		modelAndView.setViewName(defaultErrorView);
		
		// TODO Auto-generated method stub
		return modelAndView;
	}

}
