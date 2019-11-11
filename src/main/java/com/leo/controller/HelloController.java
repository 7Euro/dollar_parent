package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author zll
 * @date 2019/11/4 13:19
 **/

@Controller
public class HelloController {

    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "heool";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        //classpath:/templates/success.html
        map.put("hello","你好啊哈哈哈");
        return "success";
    }
}
