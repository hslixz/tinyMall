package com.hslixz.mall.service;

/**
 * redis操作service
 * @author l
 * @since 0.1
 */
public interface IRedisService {
    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key, String value);

    String get(String key);

    boolean expire(String key, Long expire);

    void remove(String key);

    Long increment(String key, Long delta);
}
