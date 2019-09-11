package com.example.demo.config;

import com.example.demo.task.InitJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author lph
 * @Date 2019/9/10 9:39
 */
@Service
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private QuartzManager manager;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //添加一个初始化任务，每秒轮询数据库取数据
        manager.addJob("init1", "Init", "triInit1", "triInit", InitJob.class, "*/10 * * * * ?", null);
    }
}
