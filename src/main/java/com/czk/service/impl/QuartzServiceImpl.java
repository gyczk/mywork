package com.czk.service.impl;

import com.czk.dao.SchedulerJobMapper;
import com.czk.domain.SchedulerJob;
import com.czk.domain.SysRole;
import com.czk.service.QuartzService;
import com.czk.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class QuartzServiceImpl implements QuartzService{
    @Resource
    private SchedulerJobMapper schedulerJobMapper;

    @Override
    public PageUtils<SchedulerJob> getQuartzList(PageUtils<SchedulerJob> pageUtils, SchedulerJob condition) {
        PageHelper.startPage(pageUtils.getOffset(), pageUtils.getLimit());
        List<SchedulerJob> list = schedulerJobMapper.getSchedulerListByCondition(condition);
        PageInfo<SchedulerJob> pageInfo = new PageInfo<>(list);
        pageUtils.setRows(list);
        pageUtils.setTotal((int) pageInfo.getTotal());
        return pageUtils;
    }
}
