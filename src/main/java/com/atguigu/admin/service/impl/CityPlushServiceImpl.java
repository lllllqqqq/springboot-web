package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityPlusMapper;
import com.atguigu.admin.service.CityPlushService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @create 2021-07-11-17:09
 */
@Service
public class CityPlushServiceImpl extends ServiceImpl<CityPlusMapper, City> implements CityPlushService {
}
