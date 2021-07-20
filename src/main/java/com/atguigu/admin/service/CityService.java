package com.atguigu.admin.service;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @create 2021-07-10-18:12
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City getCityByid(Long id) {
        return cityMapper.getCityById(id);
    }

    public void insertCity(City city) {
        cityMapper.insert(city);
    }
}
