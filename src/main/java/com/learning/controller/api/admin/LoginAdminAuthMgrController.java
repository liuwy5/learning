package com.learning.controller.api.admin;

import com.learning.service.IAdminLoginService;
import com.learning.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by lw on 16-12-16.
 */
@RestController
@RequestMapping("/admin/login")
public class LoginAdminAuthMgrController {
    @Autowired
    private IAdminLoginService adminLoginService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public Integer auth(LoginVo loginVo, HttpSession session) {
        return adminLoginService.auth(loginVo, session);
    }
}
