package com.learning.vo;

import java.util.List;

/**
 * 根据兴趣类型形成的非好友分组
 * Created by lw on 16-12-25.
 */
public class InterestFriendVo {
    private Integer interestCode;

    private String interestMenu;

    private List<FriendVo> InterestFriendList;

    public Integer getInterestCode() {
        return interestCode;
    }

    public void setInterestCode(Integer interestCode) {
        this.interestCode = interestCode;
    }

    public String getInterestMenu() {
        return interestMenu;
    }

    public void setInterestMenu(String interestMenu) {
        this.interestMenu = interestMenu;
    }

    public List<FriendVo> getInterestFriendList() {
        return InterestFriendList;
    }

    public void setInterestFriendList(List<FriendVo> interestFriendList) {
        InterestFriendList = interestFriendList;
    }
}
