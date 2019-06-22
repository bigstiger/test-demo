package com.stiger.exportExcel;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Auther: zheng.yuan
 * @Date: 2019/6/22 16:06
 * @Description:
 */
@Data
@TableName(value = "test")
public class Student {
    @TableField(value = "id")
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "city")
    private String city;
    @TableField(value = "age")
    private Integer age;
}
