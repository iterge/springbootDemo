package com.example.demo.config;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Description 定时任务配置
 * @Author lph
 * @Date 2019/9/9 10:24
 */
@Configuration
public class QuartzConfiguration {

    private JobFactory jobFactory;

    public QuartzConfiguration(JobFactory jobFactory) {
        this.jobFactory = jobFactory;
    }

    /**
     * 配置SchedulerFactoryBean
     * 将一个方法产生为Bean并交给Spring容器管理
     *
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        // Spring提供SchedulerFactoryBean为Scheduler提供配置信息,并被Spring容器管理其生命周期
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        //启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        // 设置自定义Job Factory，用于Spring管理Job bean
        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean(name = "scheduler")
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}
