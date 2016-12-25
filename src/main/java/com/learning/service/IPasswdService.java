package com.learning.service;

import com.learning.domain.PasswdDomain;
import com.learning.vo.InterestFriendVo;

import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
public interface IPasswdService {
    List<PasswdDomain> passwdList();

    /**
     * 首页非好友 依兴趣而成的组
     */
    List<InterestFriendVo> getInterestFriend(String selfLoginName);
}
