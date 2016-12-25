package com.learning.persistence;

import com.learning.domain.MessageDomain;

public interface MessageDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageDomain record);

    int insertSelective(MessageDomain record);

    MessageDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageDomain record);

    int updateByPrimaryKey(MessageDomain record);
}