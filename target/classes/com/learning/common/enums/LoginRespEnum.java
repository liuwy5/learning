package com.learning.common.enums;

/**
 *
 * Created by lw on 16-12-16.
 */
public enum LoginRespEnum {
    LOGIN_SUCCESS(0, "登录成功"),
    LOGIN_NO_VALID_LOGIN_NAME(1, "登录名不存在"),
    LOGIN_NO_VALID_PASSWORD(2, "登录密码不正确");

    LoginRespEnum(Integer code, String mean) {
        this.code = code;
        this.mean = mean;
    }

    private Integer code;
    private String mean;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public static LoginRespEnum valueOfCode(Integer code) {
        for (LoginRespEnum loginRespEnum : LoginRespEnum.values()) {
            if (loginRespEnum.getCode().equals(code)) {
                return loginRespEnum;
            }
        }
        return null;
    }
}
