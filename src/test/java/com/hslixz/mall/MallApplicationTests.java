package com.hslixz.mall;

import com.hslixz.mall.service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallApplicationTests {

    @MockBean
    private IRedisService redisService;
    @Test
    public void contextLoads() throws Exception {
        redisService.set("hello", "world");
        String hello = redisService.get("hello");
        System.out.println(hello);
    }

}
