package com.czk.service;

import com.czk.domain.SchedulerJob;
import com.czk.utils.PageUtils;

import java.util.List;

public interface QuartzService {
    PageUtils<SchedulerJob> getQuartzList(PageUtils<SchedulerJob> pageUtils, SchedulerJob condition);

    List<SchedulerJob> getAllJobs();

    boolean addJob(SchedulerJob schedulerJob);
}
