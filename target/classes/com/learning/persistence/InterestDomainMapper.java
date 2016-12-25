package com.learning.persistence;

import com.learning.domain.InterestDomain;

public interface InterestDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterestDomain record);

    int insertSelective(InterestDomain record);

    InterestDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterestDomain record);

    int updateByPrimaryKey(InterestDomain record);
}