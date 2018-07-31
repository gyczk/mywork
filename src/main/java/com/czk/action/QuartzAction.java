package com.czk.action;

import com.czk.domain.SchedulerJob;
import com.czk.service.QuartzService;
import com.czk.utils.PageUtils;

import com.czk.utils.R;
import org.quartz.Scheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/quartz")
public class QuartzAction {


    @Resource
    private QuartzService quartzService;

    @RequestMapping("")
    public String list(){
        return "quartz/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public PageUtils<SchedulerJob> roleList(PageUtils<SchedulerJob> pageUtils, SchedulerJob condition){
        pageUtils = quartzService.getQuartzList(pageUtils,condition);
        return pageUtils;
    }

    @PostMapping
    public R open(){

        return null;
    }

    @GetMapping("/add_page")
    public String add_page(){
        return "quartz/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public R add(SchedulerJob schedulerJob){
        schedulerJob.setJobStatus("1");
        boolean flag = quartzService.addJob(schedulerJob);
        if(flag){
            return R.ok();

        }
        return R.error();
    }

}
