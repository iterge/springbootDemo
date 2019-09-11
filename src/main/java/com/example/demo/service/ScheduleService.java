package com.example.demo.service;

import com.example.demo.entity.Schedule;

/**
 * @Description
 * @Author lph
 * @Date 2019/9/9 19:50
 */
public interface ScheduleService {
    /**
     * 获取所有需要运行的数据
     */
    Object getJobData(String status);

    /**
     * 添加任务数据
     *
     * @param schedule 任务
     * @return
     */
    boolean addJob(Schedule schedule);

    /**
     * 删除任务数据
     *
     * @param jobName 任务名
     */
    void deleteJob(String jobName);

    /**
     * 修改任务数据
     */
    void updateJob();
}
