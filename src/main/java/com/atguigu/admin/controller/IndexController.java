package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.CityService;
import com.atguigu.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author lq
 * @create 2021-07-09-11:12
 */
@Slf4j
@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;
    @Autowired
    CityService cityService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @ResponseBody
    @PostMapping("/city")
    public void insertCity(City city){
       cityService.insertCity(city);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getCityByid(id);
    }

    @ResponseBody
    @GetMapping("/user")
    public User getById(@RequestParam("id") Long id){
        return userService.getUserByid(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from customer", Long.class);
        return aLong.toString();
    }
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @GetMapping("/")
    public String main(Model model) {
        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    //解决重新刷新
    /**
     * 去main页面
     */
    public String mainPage(HttpSession session, Model model) {
        log.info("当前方式是：{}", "mainPage");
        //是否登录。 拦截器，过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String s = opsForValue.get("/main.html");
        String s1 = opsForValue.get("/sql");

        model.addAttribute("mainCount",s);
        model.addAttribute("sqlCount",s1);

        return "main";
    }
}
