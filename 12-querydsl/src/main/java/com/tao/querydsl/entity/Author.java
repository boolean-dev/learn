package com.tao.querydsl.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 作者
 *
 * @author Jiantao Yan
 * @title: Author
 * @date 2021/3/27 14:08
 */
@Data
@Entity(name = "tb_author")
public class Author implements Serializable {

    private static final long serialVersionUID = -515287580119165940L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;

    private LocalDateTime birthday;


}
