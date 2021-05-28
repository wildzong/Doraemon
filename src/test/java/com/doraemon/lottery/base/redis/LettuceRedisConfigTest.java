package com.doraemon.lottery.base.redis;

import com.doraemon.lottery.login.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class LettuceRedisConfigTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testString() {
        User user = new User();
        user.setId(1L);
        user.setUserName("wildzong");
        user.setPassword("123456");
        user.setToken("123456");
        redisTemplate.opsForValue().set("zong", user);
        System.out.println(redisTemplate.opsForValue().get("zong"));
    }

}