package com.learning.domain;

import java.util.Date;

public class FriendDomain {
    private Integer id;

    private String uuid;

    private String loginNameA;

    private String loginNameB;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getLoginNameA() {
        return loginNameA;
    }

    public void setLoginNameA(String loginNameA) {
        this.loginNameA = loginNameA == null ? null : loginNameA.trim();
    }

    public String getLoginNameB() {
        return loginNameB;
    }

    public void setLoginNameB(String loginNameB) {
        this.loginNameB = loginNameB == null ? null : loginNameB.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}