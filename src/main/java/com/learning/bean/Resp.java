package com.learning.bean;

/**
 *
 * Created by lw on 16-12-19.
 */
public class Resp {
    private Integer code;

    private String desc;

    public Resp(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
