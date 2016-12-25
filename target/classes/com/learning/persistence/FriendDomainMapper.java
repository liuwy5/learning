package com.learning.persistence;

import com.learning.domain.FriendDomain;

import java.util.List;

public interface FriendDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FriendDomain record);

    int insertSelective(FriendDomain record);

    FriendDomain selectByPrimaryKey(Integer id);

    List<FriendDomain> selectByLoginName(String loginName);

    int updateByPrimaryKeySelective(FriendDomain record);

    int updateByPrimaryKey(FriendDomain record);
}