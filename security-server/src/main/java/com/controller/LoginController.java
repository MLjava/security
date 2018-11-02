package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：linma
 * @date: 2018/10/31 14:13
 * @email: linma@homeinns.com
 **/
@Controller
@RequestMapping("/homeinns")
public class LoginController {

    public static final String LOGIN = "login";

    public static final String INDEX = "index";

    @GetMapping("/login")
    public String login() {
        return LOGIN;
    }

    @GetMapping("/index")
    public String index() {
        return INDEX;
    }
}
