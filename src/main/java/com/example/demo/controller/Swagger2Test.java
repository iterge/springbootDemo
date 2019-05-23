package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/31.
 */
@RestController
@Api(value = "Swagger2Test",tags = "测试")
public class Swagger2Test {
    @ApiOperation(value = "测试Swagger的接口" ,notes = "根据id查询")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/swagger/{id}",method = RequestMethod.POST)
    public String swaggerTest(@PathVariable(value = "id") Integer id){
        return "返回swagger"+id;
    }
}
