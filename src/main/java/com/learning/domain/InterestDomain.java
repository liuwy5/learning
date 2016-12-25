package com.learning.domain;

import java.util.Date;

public class InterestDomain {
    private Integer id;

    private String uuid;

    private Integer interest;

    private String sendLoginName;

    private String content;

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

    public Integer getInterest() {
        return interest;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    public String getSendLoginName() {
        return sendLoginName;
    }

    public void setSendLoginName(String sendLoginName) {
        this.sendLoginName = sendLoginName == null ? null : sendLoginName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}