package com.tao.querydsl.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.EAGER;

/**
 * book 实体
 *
 * @author Jiantao Yan
 * @title: Book
 * @date 2021/3/27 14:06
 */

@Data
@Entity(name = "tb_book")
public class Book implements Serializable {

    private static final long serialVersionUID = -5541522787507838001L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long authorId;

    private String name;

    private BigDecimal price;


    private LocalDateTime publishTime;

    @ManyToOne(fetch = EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), name = "authorId", insertable = false, updatable = false)
    private Author author;


}
