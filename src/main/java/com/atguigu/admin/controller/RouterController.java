package com.atguigu.admin.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author lq
 * @create 2021-07-17-21:36
 */
@Controller
public class RouterController {
    /**
     * 来登录页面
     *
     * @return
     */

//    @RequestMapping(value = "/toLogin")
//    public String toLogin(){
//        return "login";
//    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "main";
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "main";
    }

}
