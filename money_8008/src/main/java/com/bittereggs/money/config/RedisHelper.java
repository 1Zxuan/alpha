package com.bittereggs.money.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
