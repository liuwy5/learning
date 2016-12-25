package com.learning.vo;

/**
 *
 * Created by lw on 16-12-21.
 */
public class RegisterVo {
    private String registerName;

    private String registerPwd;

    private String name;

    private Integer gender;

    private String tel;

    private String email;

    private Integer national;

    private String interest;


    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterPwd() {
        return registerPwd;
    }

    public void setRegisterPwd(String registerPwd) {
        this.registerPwd = registerPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
