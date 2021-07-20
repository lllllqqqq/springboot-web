package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.exception.UserTooManyException;
import com.atguigu.admin.mapper.CityPlusMapper;
import com.atguigu.admin.service.CityPlushService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * @author lq
 * @create 2021-07-09-11:55
 */
@Controller
public class TableController {

    @Autowired
    CityPlushService cityPlushService;

    /**
     *
     * @param a 不带请求参数或者参数类型不对 400； Bad Request 一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i = 10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                                Model model){
        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("zhangsanA", "123456"),
//                new User("zhangsanAA", "123456"),
//                new User("zhangsanAAA", "123456"));
//        model.addAttribute("users",users);
//        if(users.size()>3){
//            throw new UserTooManyException();
//        }
        List<City> list = cityPlushService.list();

//        model.addAttribute("citys",list);
        //分页
        Page<City> citiesPage = new Page<>(pn, 5);
        //分页查询的结果
        Page<City> page = cityPlushService.page(citiesPage, null);

        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}

