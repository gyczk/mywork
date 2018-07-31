package quartz;




import org.junit.Test;


import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


public class JobRun {

    public static  Scheduler getScheduler(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext-dao.xml","applicationContext-quartz.xml"});
        Scheduler scheduler = (Scheduler) applicationContext.getBean("schedulerFactoryBean");
        return scheduler;
    }

    public static  void test(){
        Scheduler scheduler = getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob","group5").build();
        CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? ");
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triger","group5").startNow().withSchedule(builder).build();
        try {
            scheduler.start();
            scheduler.scheduleJob(jobDetail,trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        test();
    }

}
