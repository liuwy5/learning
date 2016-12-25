package com.learning.service;

import com.learning.vo.LoginVo;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by lw on 16-12-16.
 */
public interface IAdminLoginService {
    Integer auth(LoginVo loginVo, HttpSession session);
}
