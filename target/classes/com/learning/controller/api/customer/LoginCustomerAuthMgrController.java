package com.learning.controller.api.customer;

import com.learning.bean.Resp;
import com.learning.service.ICustomerLoginService;
import com.learning.vo.LoginVo;
import com.learning.vo.ModifyPasswdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by lw on 16-12-21.
 */
@RestController
@RequestMapping("/customer/login")
public class LoginCustomerAuthMgrController {
    @Autowired
    private ICustomerLoginService customerLoginService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Integer auth(LoginVo loginVo, HttpSession session) {
        return customerLoginService.auth(loginVo, session);
    }

    @RequestMapping(value = "/changePwd", method = RequestMethod.POST)
    public Resp changePwd(ModifyPasswdVo modifyPasswdVo, HttpSession session) {
        return customerLoginService.changePwd(modifyPasswdVo, session);
    }
}
