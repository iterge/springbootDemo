package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description
 * @Author lph
 * @Date 2019/5/23 18:25
 */
@Component
public class IdGenerator {
    public static String getIdByUUId(){
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
}
