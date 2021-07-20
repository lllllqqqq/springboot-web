package com.atguigu.admin.service;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @create 2021-07-10-17:41
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserByid(Long id){
        return userMapper.getUser(id);
    }
}
