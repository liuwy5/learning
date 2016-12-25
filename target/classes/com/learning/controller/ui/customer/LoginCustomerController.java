package com.learning.controller.ui.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by lw on 16-12-16.
 */
@Controller
@RequestMapping("/login")
public class LoginCustomerController {
    @RequestMapping("")
    public String login(Model model) {
        model.addAttribute("name", "name111");
        return "customer/login";
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        session.setAttribute("ticket", null);
        return "redirect:/";
    }
}
