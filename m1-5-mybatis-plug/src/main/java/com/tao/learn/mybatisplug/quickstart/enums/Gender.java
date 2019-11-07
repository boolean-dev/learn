package com.tao.learn.mybatisplug.quickstart.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.Getter;

/**
 * 性别枚举
 */
@Getter
public enum Gender {

    // 未知
    NONE(0,"未知"),
    // 女
    MALE(1, "男"),
    // 男
    FEMALE(2, "女");


    /**
     * code
     */
    @EnumValue
    private Integer code;

    /**
     * 描述
     */
    private String desc;

    Gender(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
