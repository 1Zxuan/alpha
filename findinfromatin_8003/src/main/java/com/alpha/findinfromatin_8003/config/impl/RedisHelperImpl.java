package com.alpha.findinfromatin_8003.config.impl;

import com.alpha.findinfromatin_8003.config.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 楼中煊
 * @data 2019/3/28
 * @time 20:47
 */

@Service("RedisHelper")
public class RedisHelperImpl<HK, T> implements RedisHelper<HK,T> {

    private RedisTemplate<String,T> redisTemplate;

    private HashOperations<String,HK,T> hashOperations;

    private ListOperations<String,T> listOperations;

    private ZSetOperations<String,T> zSetOperations;

    private SetOperations<String,T> setOperations;

    private ValueOperations<String,T> valueOperations;

    @Autowired
    public RedisHelperImpl(RedisTemplate<String,T> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.zSetOperations = redisTemplate.opsForZSet();
        this.setOperations = redisTemplate.opsForSet();
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void hashPut(String key, HK hashkey, T domain) {
        hashOperations.put(key,hashkey,domain);
    }

    @Override
    public Map hashFindAll(String key) {
        return hashOperations.entries(key);
    }

    @Override
    public T hashGet(String key, HK hashKey) {
        return hashOperations.get(key,hashKey);
    }

    @Override
    public void hashRemove(String key, HK hashkey) {
        hashOperations.delete(key,hashkey);
    }

    @Override
    public Long listPush(String key, T domain) {
        return listOperations.leftPush(key,domain);
    }

    @Override
    public List<T> listFindAll(String key) {
        if(!redisTemplate.hasKey(key)){
            return null;
        }
        return listOperations.range(key,0,listOperations.size(key));
    }

    @Override
    public T listLPop(String key) {
        return listOperations.leftPop(key);
    }

    @Override
    public void valuePut(String key, T domain) {
        valueOperations.set(key,domain);
    }

    @Override
    public T getValue(String key) {
        return valueOperations.get(key);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public boolean expirse(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key,timeout,timeUnit);
    }
}
