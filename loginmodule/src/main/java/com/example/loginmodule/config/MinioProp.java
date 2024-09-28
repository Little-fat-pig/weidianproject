package com.example.loginmodule.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 *@author zhangxl
 *@Date 2024/9/28 10:52
 *@description
 *
 * 这种获取配置文件变量的形式，没有使用过  可能获取不到数据
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProp {

    //连接url
    private String endpoint;
    //公钥
    private String accesskey;
    //私钥
    private  String secretkwy;
}
