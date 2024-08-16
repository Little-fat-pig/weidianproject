package com.example.loginmodule.util;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/7/30 11:09
 */
@Component
public class RedisUtils {


    @Resource(name = "redisTemplateTest")
    private RedisTemplate<String,Object> redisTemplate;


    public ValueOperations<String,Object> getStringObject() {
        return redisTemplate.opsForValue();
    }

    public ListOperations<String,Object> getListObject() {
        return redisTemplate.opsForList();
    }


    public HashOperations<String,String,Object> getHashObject() {
        return redisTemplate.opsForHash();
    }


    public SetOperations<String,Object> getSetObject() {
        return redisTemplate.opsForSet();
    }


    public ZSetOperations<String,Object> getZSetObject() {
        return redisTemplate.opsForZSet();
    }


}
