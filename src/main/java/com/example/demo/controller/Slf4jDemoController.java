package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/1/31.
 */
@Controller
@Slf4j
@RequestMapping("/demo")
public class Slf4jDemoController {
    //private static final Logger log = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "/getStr",method = RequestMethod.POST)
    @ResponseBody
    public String getStr(){
        log.info("这是slf4j注解测试。");
        return "是这样的";
    }
}
