package com.bittereggs.admin_8009.mapper;

import com.bittereggs.admin_8009.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "UserManagerMapper")
public interface UserManagerMapper {
    List<User> getUser();

    void upUser(User user);

    void delUser(String username);
}
