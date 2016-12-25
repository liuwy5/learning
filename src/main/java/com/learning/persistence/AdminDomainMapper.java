package com.learning.persistence;

import com.learning.domain.AdminDomain;
import com.learning.vo.AdminListVo;

import java.util.List;

public interface AdminDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminDomain record);

    int insertSelective(AdminDomain record);

    AdminDomain selectByPrimaryKey(Integer id);

    AdminDomain selectOne(AdminDomain adminDomain);

    List<AdminListVo> selectAll();

    int updateByPrimaryKeySelective(AdminDomain record);

    int updateByPrimaryKey(AdminDomain record);
}