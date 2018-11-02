package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author：linma
 * @date: 2018/10/31 11:34
 * @email: linma@homeinns.com
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("com.dao")
public class SecurityApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void contexts() {
        redisTemplate.opsForValue().set("hello", "java");
    }

}
