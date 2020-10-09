package com.tao.learn.mybatisplug.quickstart.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.tao.learn.mybatisplug.quickstart.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 谛听
 * @date 2019/11/7 10:29
 **/

@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ToString
public class User implements Serializable{


    private static final long serialVersionUID = -6849981787144463430L;

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别：0无，1男，2女
     */
    private Gender gender;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime ;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

}