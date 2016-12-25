package com.learning.persistence;

import com.learning.domain.PasswdDomain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PasswdDomainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PasswdDomain record);

    int insertSelective(PasswdDomain record);

    PasswdDomain selectByPrimaryKey(Integer id);

    PasswdDomain selectByLoginName(String loginName);

    List<PasswdDomain> selectAll();

    List<PasswdDomain> selectByInterest(String interestCodeString);

    List<PasswdDomain> selectByInterestExceptSelf(@Param("interestCodeString") String interestCodeString, @Param("selfLoginName") String selfLoginName);

    int updateByPrimaryKeySelective(PasswdDomain record);

    int updateByPrimaryKey(PasswdDomain record);
}