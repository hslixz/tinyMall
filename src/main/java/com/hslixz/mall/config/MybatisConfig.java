package com.hslixz.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author l
 * @description Mybatis配置类
 * @time 2019/6/26 10:25
 */
@Configuration
@MapperScan("com.hslixz.mall.mbg.mapper")
public class MybatisConfig {
}
