package com.leo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Leo
 */
@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "1".equals(password)) {
            //登录成功,防止表单重复提交，进行重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
