package com.example.loginmodule.sync;

import com.example.loginmodule.core.entity.UserEntity;
import com.example.loginmodule.result.BaseResult;
import com.example.loginmodule.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/7/29 20:20
 */
@EnableScheduling
@Component
@Slf4j
public class SyncRedis {

//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private AsyncService asyncService;


    @Autowired
    private UserService userService;

    @Scheduled(cron = "${sync.id}")
    public void syncRedis() {
//        redisService.setValues();

        //可以开发几个  关于  同步  异步   阻塞   非阻塞   或者组合的接口

//        asyncService.asyncMethod();


//        try {
//            CompletableFuture<String> stringCompletableFuture = asyncService.asyncCompletableFutureMethod();
//            String s = stringCompletableFuture.get();
//            System.out.println(s);
//        } catch (Exception e) {
//            log.error("获取回调接口数据异常" + e);
//        }


    }

//
//    @Scheduled(cron = "${sync.activemq}")
//    public void syncActiveMq() {
//        for (int i = 0; i < 150; i++) {
//            asyncService.sendInfoMq();
//            log.info(UUID.randomUUID().toString().replaceAll("-","") + "时间" + System.currentTimeMillis() + Thread.currentThread().getName());
//        }
//    }


    @Scheduled(cron = "${sync.activemq}")
    public void registerUser() {
        //设计注册的用户名和密码  用户名目前只是用手机号模拟   密码就设计4为
        //
        for (int i = 0; i < 100; i++) {
            UserEntity user = new UserEntity();
            int password = new Random().nextInt(9999) + 1000;
            String phoneNumber = "133" + password + "4759";
            user.setUsername(phoneNumber);
            user.setPassword(password + "");
            BaseResult<?> baseResult = userService.loginOrRegister(user);
            log.info("用户注册的结果{}", baseResult);

        }
    }


}
