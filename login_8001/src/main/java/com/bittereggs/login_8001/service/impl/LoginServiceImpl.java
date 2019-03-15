package com.bittereggs.login_8001.service.impl;

import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.mapper.LoginMapper;
import com.bittereggs.login_8001.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void add(User user) {

    }

    @Override
    public Boolean login(User user) {

        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        Boolean exist = redisTemplate.hasKey(user);
        if(exist){
            return true;
        }else{
            exist = this.loginMapper.login(user);
            if(exist){
                return exist;
            }else
                return exist;
        }
    }

    @Override
    public Boolean adminlogin(User user) {
        return false;
    }
}
