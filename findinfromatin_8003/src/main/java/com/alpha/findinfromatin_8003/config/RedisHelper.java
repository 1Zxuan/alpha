package com.alpha.findinfromatin_8003.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 楼中煊
 * @data 2019/3/28
 * @time 20:44
 */
public interface RedisHelper<HK, T> {

    void hashPut(String key, HK hashkey, T domain);

    Map<HK, T> hashFindAll(String key);

    T hashGet(String key, HK hashKey);

    void hashRemove(String key, HK hashkey);

    Long listPush(String key, T domain);

    List<T> listFindAll(String key);

    T listLPop(String key);

    void valuePut(String key, T domain);

    T getValue(String key);

    void remove(String key);

    boolean expirse(String key, long timeout, TimeUnit timeUnit);
}
