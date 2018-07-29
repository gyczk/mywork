package com.czk.service;

import com.czk.domain.SchedulerJob;
import com.czk.utils.PageUtils;

public interface QuartzService {
    PageUtils<SchedulerJob> getQuartzList(PageUtils<SchedulerJob> pageUtils, SchedulerJob condition);
}
