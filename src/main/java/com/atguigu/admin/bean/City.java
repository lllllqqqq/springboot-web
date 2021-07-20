package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author lq
 * @create 2021-07-10-18:08
 */
@Data
public class City {
    //设置主键自增在id上
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String state;
    private String counntry;
    //为时间添加默认值
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;

}
