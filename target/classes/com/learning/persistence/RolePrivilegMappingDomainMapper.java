package com.learning.persistence;

import com.learning.domain.RolePrivilegMappingDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePrivilegMappingDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByRoleUuid(@Param("roleUuid") String roleUuid);

    int insert(RolePrivilegMappingDomain record);

    int insertSelective(RolePrivilegMappingDomain record);

    RolePrivilegMappingDomain selectByPrimaryKey(Integer id);

    List<RolePrivilegMappingDomain> selectByRoleUuid(@Param("roleUuid") String roleUuid);

    int updateByPrimaryKeySelective(RolePrivilegMappingDomain record);

    int updateByPrimaryKey(RolePrivilegMappingDomain record);
}