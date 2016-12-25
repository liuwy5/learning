package com.learning.persistence;

import com.learning.domain.RoleDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleDomain record);

    int insertSelective(RoleDomain record);

    List<RoleDomain> selectAll();

    RoleDomain selectByPrimaryKey(Integer id);

    RoleDomain selectByRoleName(@Param("roleName") String roleName);

    int updateByPrimaryKeySelective(RoleDomain record);

    int updateByPrimaryKey(RoleDomain record);
}