package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lq
 * @create 2021-07-10-17:26
 */
@Mapper
public interface UserMapper {
    public User getUser(Long id);
}
