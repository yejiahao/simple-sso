package com.sheefee.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value = {"/", "/test"})
    public String test() {
        return "test";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}