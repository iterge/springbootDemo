package com.example.demo.service.impl;

import com.example.demo.dao.ScheduleRepository;
import com.example.demo.entity.Schedule;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author lph
 * @Date 2019/9/9 19:52
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    @Override
    public Object getJobData(String status) {
        Iterable<Schedule> repositoryAll = repository.findByJobStatusEqule(status);
        return repositoryAll;
    }

    @Override
    public boolean addJob(Schedule schedule) {
        try {
            repository.save(schedule);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void deleteJob(String jobName) {

    }

    @Override
    public void updateJob() {

    }
}
