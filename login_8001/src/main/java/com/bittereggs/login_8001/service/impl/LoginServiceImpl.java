package com.bittereggs.login_8001.service.impl;

import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.mapper.LoginMapper;
import com.bittereggs.login_8001.service.LoginService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RedisHelper RedisHelper;

    @Override
    public Boolean add(User user) {
        //先判断redis_用户名是否已经存在
        if(RedisHelper.hashFindAll("UserList").get(user.getUsername()) == null){
            //缓存为空，判断数据库
            User user1 = this.loginMapper.findByName(user.getUsername());
            if(user1 == null){
                this.loginMapper.add(user);
                RedisHelper.hashPut("UserList",user.getUsername(),user.toString());
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public User findByName(String name) {
        User user = new User();
        JSONObject redis_user = JSONObject.fromObject(RedisHelper.hashFindAll("UserList").get(name));
        if(redis_user.isEmpty()){
            user = this.loginMapper.findByName(name);
        }else {
            user = (User) JSONObject.toBean(redis_user,User.class);
        }
        return user;
    }

//    public Boolean login(User user) {
//        ValueOperations<String,User> operations = redisTemplate.opsForValue();
//        Boolean exist = redisTemplate.hasKey(user);
//        if(exist){
//            return true;
//        }else{
//            exist = this.loginMapper.login(user);
//            if(exist){
//                return exist;
//            }else
//                return exist;
//        }
//    }

}
