package com.czk.service.impl;

import com.czk.dao.SchedulerJobMapper;
import com.czk.domain.SchedulerJob;
import com.czk.domain.SysRole;
import com.czk.service.QuartzService;
import com.czk.utils.PageUtils;
import com.czk.utils.QuartzManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class QuartzServiceImpl implements QuartzService{
    @Resource
    private SchedulerJobMapper schedulerJobMapper;
    @Resource
    private Scheduler scheduler;
    @Override
    public PageUtils<SchedulerJob> getQuartzList(PageUtils<SchedulerJob> pageUtils, SchedulerJob condition) {
        PageHelper.startPage(pageUtils.getOffset(), pageUtils.getLimit());
        List<SchedulerJob> list = schedulerJobMapper.getSchedulerListByCondition(condition);
        PageInfo<SchedulerJob> pageInfo = new PageInfo<>(list);
        pageUtils.setRows(list);
        pageUtils.setTotal((int) pageInfo.getTotal());
        return pageUtils;
    }

    @Override
    public List<SchedulerJob> getAllJobs() {
        return schedulerJobMapper.selectByExample(null);
    }

    @Override
    public boolean addJob(SchedulerJob schedulerJob) {

        try {
            QuartzManager.addJob(scheduler,schedulerJob.getJobName(),schedulerJob.getJobGroup(),
                    "trigger1","trigerGroup",Class.forName(schedulerJob.getQuartzClass()),schedulerJob.getCronExpression());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        int count =  schedulerJobMapper.insert(schedulerJob);
        if(count>=1){
            return true;
        }
        return false;
    }
}
