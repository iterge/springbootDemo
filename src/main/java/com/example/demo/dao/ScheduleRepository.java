package com.example.demo.dao;

import com.example.demo.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description
 * @Author lph
 * @Date 2019/9/9 20:02
 */
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    //通过job状态查询所有job
    @Query(value = "select * from schedule_jobs where job_status = :jobStatus and job_cron is not null and job_cron !=''", nativeQuery = true)
    List<Schedule> findByJobStatusEqule(@Param("jobStatus") String jobStatus);
}
