package com.learning.controller.ui.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by lw on 16-12-17.
 */
@Controller
@RequestMapping("admin/culture")
public class CultureController {
    @RequestMapping("")
    public String cultuerList() {
        return "admin/culture";
    }
}
