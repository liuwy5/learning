package com.learning.persistence;

import com.learning.domain.PrivilegeDomain;
import org.apache.ibatis.annotations.Param;

public interface PrivilegeDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrivilegeDomain record);

    int insertSelective(PrivilegeDomain record);

    PrivilegeDomain selectByPrimaryKey(Integer id);

    PrivilegeDomain selectByUuid(@Param("uuid") String uuid);

    int updateByPrimaryKeySelective(PrivilegeDomain record);

    int updateByPrimaryKey(PrivilegeDomain record);
}