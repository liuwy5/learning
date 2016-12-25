package com.learning.controller.ui.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by lw on 16-12-16.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    @RequestMapping("/{friendLoginName}")
    public String chat(@PathVariable("friendLoginName") String friendLoginName, Model model) {
        model.addAttribute("friendLoginName", friendLoginName);
        return "customer/chat";
    }
}
