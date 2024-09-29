package com.example.loginmodule.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2024/7/29 20:24
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.database}")
    private Integer database;


    @Value("${spring.redis.host}")
    private String host;


    @Value("${spring.redis.port}")
    private Integer port;

    /**
     * 目前使用的redis的版本应该是redis6以下，  redis中不需要配置redis的用户名   只配置了密码
     */

//    @Value("${spring.redis.username}")
//    private String username;


    @Value("${spring.redis.password}")
    private String password;


    /**
     * 单机模式下配置的redisTemplate的工厂
     * <p>
     * RedisTemplate   只是对redis操作命令的封装    不包含布隆过滤器
     *
     * @return
     */
    @Bean("redisTemplateTest")
    public RedisTemplate<String, Object> getRedisTemplate() {

        RedisProperties.Jedis jedis = new RedisProperties.Jedis();


        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        LettuceConnectionFactory lettuceConnectionFactory = getLettuceConnectionFactory(database);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    /**
     * 配置redis连接信息
     *
     * @return
     */
    private LettuceConnectionFactory getLettuceConnectionFactory(Integer database) {
        RedisStandaloneConfiguration redisConnectionFactory = new RedisStandaloneConfiguration();
        redisConnectionFactory.setDatabase(database);
        redisConnectionFactory.setHostName(host);
        redisConnectionFactory.setPort(port);
        redisConnectionFactory.setPassword(password);
//        redisConnectionFactory.setPassword(RedisPassword.of(password));


        //如果要配置多个redis的数据库
//        LettuceClientConfiguration lettuceClientConfiguration= LettuceClientConfiguration.builder().build();
//        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisConnectionFactory,lettuceClientConfiguration);
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisConnectionFactory);

        lettuceConnectionFactory.afterPropertiesSet();

        return lettuceConnectionFactory;
    }


    @Bean("redissonClientTest")
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password).setDatabase(database);
        return Redisson.create(config);
    }
}
