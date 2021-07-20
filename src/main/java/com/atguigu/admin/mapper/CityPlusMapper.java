package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lq
 * @create 2021-07-11-12:19
 */
@Mapper
public interface CityPlusMapper extends BaseMapper<City> {
    //BaseMapper所有的CRUD操作都已经编写完成了
    //你不需要项以前的配置一大堆文件了！
    /**
     *
     */
}
