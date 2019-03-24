package com.bittereggs.login_8001.mapper;

import com.bittereggs.login_8001.entity.WxUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 14:19
 */


@Mapper
public interface WxLoginMapper {

    WxUser findbyopenid(String openid);

    void addwxuser(WxUser user);
}
