package com.bittereggs.login_8001.mapper;

import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.entity.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 14:19
 */


@Mapper
@Component(value = "WxLoginMapper")
public interface WxLoginMapper {

    WxUser findbyopenid(String openid);

    Boolean isexist(String openid);

    Boolean isexistphone(String phone);

    User findbyphone(String phone);

    void addwxuser(WxUser user);

    Boolean checkwxusername(String username);

    void fillinfo(@Param("0") String username,@Param("1") String password,@Param("2") String phone,@Param("3") String type);

    User getUserbyopenid(String open_id);
}
