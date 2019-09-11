package com.example.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description
 * @Author lph
 * @Date 2019/9/9 19:51
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule_jobs")
public class Schedule {
    @Id
    private String id;
    /**
     *
     */
    @Column(name = "job_time")
    private String jobTime;

    @Column(name = "job_cron")
    private String jobCron;

    @Column(name = "job_group")
    private String jobGroup;
    @Column(name = "job_ruleid")
    private String jobRuleid;

    public String getJobRuleid() {
        return jobRuleid;
    }

    public void setJobRuleid(String jobRuleid) {
        this.jobRuleid = jobRuleid;
    }

    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_data")
    private String jobData;
    @Column(name = "job_status")
    private String jobStatus;

    @Column(name = "job_weekend")
    private String jobWeekend;

    @Column(name = "job_holiday")
    private String jobHoliday;

    @Column(name = "job_day")
    private String jobDay;

    @Column(name = "ts")
    private Date ts;
}
