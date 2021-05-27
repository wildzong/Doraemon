package com.doraemon.lottery.base.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class LettuceRedisConfigTest {
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testString() {
        System.out.println(redisUtils.get("name"));
    }

}