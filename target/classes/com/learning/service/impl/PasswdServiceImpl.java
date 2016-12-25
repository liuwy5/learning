package com.learning.service.impl;

import com.learning.common.enums.InterestTypeEnum;
import com.learning.domain.PasswdDomain;
import com.learning.persistence.PasswdDomainMapper;
import com.learning.service.IPasswdService;
import com.learning.vo.FriendVo;
import com.learning.vo.InterestFriendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
@Service
public class PasswdServiceImpl implements IPasswdService {
    @Autowired
    private PasswdDomainMapper passwdDomainMapper;

    public List<PasswdDomain> passwdList() {
        return passwdDomainMapper.selectAll();
    }

    /**
     * 首页非好友 依兴趣而成的组
     */
    public List<InterestFriendVo> getInterestFriend(String selfLoginName) {
        List<InterestFriendVo> interestFriendVoList = new ArrayList<InterestFriendVo>(InterestTypeEnum.values().length);

        for (InterestTypeEnum interestTypeEnum : InterestTypeEnum.values()) {
            InterestFriendVo interestFriendVo = new InterestFriendVo();
            interestFriendVo.setInterestCode(interestTypeEnum.getCode());
            interestFriendVo.setInterestMenu(interestTypeEnum.getMean());


            String interestCodeString = interestTypeEnum.getCode().toString();
            List<PasswdDomain> passwdDomainList;
            if (selfLoginName == null) {
                passwdDomainList = passwdDomainMapper.selectByInterest(interestCodeString);
            } else {
                passwdDomainList = passwdDomainMapper.selectByInterestExceptSelf(interestCodeString, selfLoginName);
            }
            List<FriendVo> friendVoList = new ArrayList<FriendVo>(passwdDomainList.size());
            for (PasswdDomain passwdDomain : passwdDomainList) {
                FriendVo friendVo = new FriendVo();
                friendVo.setLoginName(passwdDomain.getLoginName());
                friendVoList.add(friendVo);
            }
            interestFriendVo.setInterestFriendList(friendVoList);

            interestFriendVoList.add(interestFriendVo);
        }

        return interestFriendVoList;
    }
}
