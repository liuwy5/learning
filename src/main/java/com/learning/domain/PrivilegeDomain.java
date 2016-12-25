package com.learning.domain;

import java.util.Date;

public class PrivilegeDomain {
    private Integer id;

    private String uuid;

    private String privilegeNo;

    private String privilegeName;

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

    public String getPrivilegeNo() {
        return privilegeNo;
    }

    public void setPrivilegeNo(String privilegeNo) {
        this.privilegeNo = privilegeNo == null ? null : privilegeNo.trim();
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}