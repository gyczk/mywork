package com.czk.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sys/blog")
public class BlogAction {

    public String addPage(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext){
        WebContext wc = new WebContext(request, response, servletContext, request.getLocale());

        return "";
    }


}
