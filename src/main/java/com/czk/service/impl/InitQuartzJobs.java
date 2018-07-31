package com.czk.service.impl;

import com.czk.domain.SchedulerJob;
import com.czk.service.QuartzService;
import com.czk.utils.QuartzManager;
import org.quartz.Scheduler;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


public class InitQuartzJobs implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private QuartzService quartzService;

    @Resource
    private Scheduler scheduler;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null) {//root application context 没有parent，他就是老大.
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            List<SchedulerJob> list = quartzService.getAllJobs();

            for(SchedulerJob schedulerJob:list){
                try {

                        QuartzManager.addJob(scheduler,schedulerJob.getJobName(),schedulerJob.getJobGroup(),"trigerName","trigerGroup",Class.forName(schedulerJob.getQuartzClass()),schedulerJob.getCronExpression());


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
