package com.learning.common.enums;

/**
 *
 * Created by lw on 16-12-19.
 */
public enum RespStatusEnum {
    RESP_SUCCESS(0, "请求成功"),
    RESP_FAIL(1, "请求异常");

    RespStatusEnum(Integer code, String mean) {
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

    public static RespStatusEnum valueOfCode(Integer code) {
        for (RespStatusEnum respStatusEnum : RespStatusEnum.values()) {
            if (respStatusEnum.getCode().equals(code)) {
                return respStatusEnum;
            }
        }
        return null;
    }
}
