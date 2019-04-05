package com.bittereggs.admin_8009.mapper;

import com.bittereggs.admin_8009.entity.Blacklist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BlacklistMapper")
public interface BlacklistMapper {

    List<Blacklist> getBlackList(Blacklist blacklist);

    void addBlackList(Blacklist blacklist);

    void delBlackList(String name);

}
