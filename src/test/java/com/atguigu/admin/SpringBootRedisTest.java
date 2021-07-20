package com.atguigu.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author lq
 * @create 2021-07-17-19:43
 */
@SpringBootTest
public class SpringBootRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads(){
        redisTemplate.opsForValue().set("mykey","关注我");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }
}
