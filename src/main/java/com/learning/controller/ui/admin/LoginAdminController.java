package com.learning.controller.ui.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by lw on 16-12-16.
 */
@Controller
@RequestMapping("admin")
public class LoginAdminController {
    @RequestMapping("/login")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping("/login/out")
    public String adminLoginOut(HttpSession session) {
        session.setAttribute("ticket", null);
        return "redirect:/admin/login";
    }
}
