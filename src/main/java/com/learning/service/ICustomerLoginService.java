package com.learning.service;

import com.learning.bean.Resp;
import com.learning.vo.LoginVo;
import com.learning.vo.ModifyPasswdVo;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by lw on 16-12-21.
 */
public interface ICustomerLoginService {
    Integer auth(LoginVo loginVo, HttpSession session);

    Resp changePwd(ModifyPasswdVo modifyPasswdVo, HttpSession session);
}
