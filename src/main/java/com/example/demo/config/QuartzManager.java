package com.example.demo.config;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Component;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Description
 * @Author lph
 * @Date 2019/9/9 19:14
 */
@Component
public class QuartzManager {
    private Scheduler scheduler;
    private JobDetail jobDetail;

    public QuartzManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Boolean checkJob(String jobName1, String groupName1) {
        try {
            boolean flag = false;
            for (String groupName : scheduler.getJobGroupNames()) {
                for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                    String jobName = jobKey.getName();
                    if (jobName1 != null && !"".equals(jobName1) && groupName1 != null && !"".equals(groupName1)) {
                        if (jobName1.equals(jobName) && groupName1.equals(groupName)) {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加定时任务
     */
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class cls,
                       String time, Object data) {
        System.out.println("查询数据库了");
        try {
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
            this.jobDetail = newJob(cls).withIdentity(jobName, jobGroupName).build();
            jobDetail.getJobDataMap().put("data", data);
            CronTrigger cronTrigger = newTrigger().withIdentity(triggerName, triggerGroupName)
                    .withSchedule(cronSchedule(time)).build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除定时任务
     */
    public boolean deleteJob(String jobName, String groupName) {
        boolean result = false;
        try {
            JobKey jobKey = new JobKey(jobName, groupName);
            if (scheduler.checkExists(jobKey)) {
                result = scheduler.deleteJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 停止任务
     */
    public void pauseJob(String jobName, String groupName) {
        try {
            JobKey jobKey = new JobKey(jobName, groupName);
            if (scheduler.checkExists(jobKey)) {
                scheduler.pauseJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 再次启动Job
     *
     * @param jobName
     * @param groupName
     */
    public void resumeJob(String jobName, String groupName) {
        try {
            JobKey jobKey = new JobKey(jobName, groupName);
            if (scheduler.checkExists(jobKey)) {
                scheduler.resumeJob(jobKey);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public JobDetail getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
    }
}
