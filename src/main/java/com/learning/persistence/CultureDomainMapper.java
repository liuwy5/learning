package com.learning.persistence;

import com.learning.domain.CultureDomain;

import java.util.List;

public interface CultureDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CultureDomain record);

    int insertSelective(CultureDomain record);

    List<CultureDomain> selectAll();

    CultureDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CultureDomain record);

    int updateByPrimaryKeyWithBLOBs(CultureDomain record);

    int updateByPrimaryKey(CultureDomain record);
}