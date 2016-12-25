package com.learning.service.impl;

import com.learning.bean.Ticket;
import com.learning.common.enums.LoginRespEnum;
import com.learning.domain.AdminDomain;
import com.learning.persistence.AdminDomainMapper;
import com.learning.service.IAdminLoginService;
import com.learning.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * AdminLoginServiceImpl
 * Created by lw on 16-12-16.
 */
@Service
public class AdminLoginServiceImpl implements IAdminLoginService {
    @Autowired
    private AdminDomainMapper adminDomainMapper;

    public Integer auth(LoginVo loginVo, HttpSession session) {
        AdminDomain adminDomain = new AdminDomain();
        adminDomain.setLoginName(loginVo.getLoginName());

        adminDomain = adminDomainMapper.selectOne(adminDomain);

        if (adminDomain == null) {
            return LoginRespEnum.LOGIN_NO_VALID_LOGIN_NAME.getCode();
        } else {
            if (adminDomain.getPassword().equals(loginVo.getLoginPwd())) {
                Ticket ticket = new Ticket();
                ticket.setLoginName(loginVo.getLoginName());
                ticket.setName(loginVo.getLoginName());
                session.setAttribute("ticket", ticket);

                return LoginRespEnum.LOGIN_SUCCESS.getCode();
            } else {
                return LoginRespEnum.LOGIN_NO_VALID_PASSWORD.getCode();
            }
        }
    }
}
