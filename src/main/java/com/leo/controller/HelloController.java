package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zll
 * @date 2019/11/4 13:19
 **/
@ResponseBody
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "heool";
    }
}
