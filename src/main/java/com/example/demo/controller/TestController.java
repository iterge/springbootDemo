package com.example.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/31.
 */
@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    public String test(){
        log.info("*************test************");
        String str = "hello world";
        return "123";
    }

    @ApiOperation(value = "求一个数的5倍方法",notes = "输入一个整数")
    @ApiImplicitParam(name = "num",value = "用户输入的参数",dataType = "int",paramType = "path")
    @GetMapping("/getSum/{num}")
    public int getSum(@PathVariable("num") int num){
        return 5*num;
    }
}
