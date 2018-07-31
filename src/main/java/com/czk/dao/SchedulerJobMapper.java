package com.czk.dao;

import com.czk.domain.SchedulerJob;
import com.czk.domain.SchedulerJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchedulerJobMapper {
    int countByExample(SchedulerJobExample example);

    int deleteByExample(SchedulerJobExample example);

    int deleteByPrimaryKey(Long jobid);

    int insert(SchedulerJob record);

    int insertSelective(SchedulerJob record);

    List<SchedulerJob> selectByExample(SchedulerJobExample example);

    SchedulerJob selectByPrimaryKey(Long jobid);

    int updateByExampleSelective(@Param("record") SchedulerJob record, @Param("example") SchedulerJobExample example);

    int updateByExample(@Param("record") SchedulerJob record, @Param("example") SchedulerJobExample example);

    int updateByPrimaryKeySelective(SchedulerJob record);

    int updateByPrimaryKey(SchedulerJob record);

    List<SchedulerJob> getSchedulerListByCondition(SchedulerJob condition);
}