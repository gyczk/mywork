package com.czk.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintJob implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("job begin"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
