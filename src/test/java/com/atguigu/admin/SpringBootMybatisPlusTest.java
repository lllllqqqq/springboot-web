package com.atguigu.admin;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityPlusMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author lq
 * @create 2021-07-11-15:09
 */
@SpringBootTest
@Slf4j
public class SpringBootMybatisPlusTest {

    @Autowired
    private CityPlusMapper cityPlusMapper;

    @Test
    void Querry() {
        //参数是一个wrapper,条件构造器，这里我们先不用null
        //查询全部客户
        List<City> cities = cityPlusMapper.selectList(null);
        for (City city : cities) {
            System.out.println(city);
        }
    }

    @Test
    void testUpdate(){
        City city = new City();
        city.setId(6L);
        city.setName("北京");
        city.setState("扬州");
        city.setCounntry("中国");

        //int i = cityPlusMapper.insert(city);  //不需要
        int i = cityPlusMapper.updateById(city);//需要id
        System.out.println(i);
    }

    //测试查询
    @Test
    public void testSelectById(){
        City city = cityPlusMapper.selectById(1);
        System.out.println(city);
    }

    @Test
    public void testSelectByBatchId(){
        List<City> cities = cityPlusMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        cities.forEach(System.out::println);
    }

    //按条件查询之一使用map操作
    @Test
    public void testSelectBuBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义要查询
        map.put("name","ee");
        map.put("state","aa");
        map.put("counntry","dd");

        List<City> cities = cityPlusMapper.selectByMap(map);
        cities.forEach(System.out::println);
    }

}

