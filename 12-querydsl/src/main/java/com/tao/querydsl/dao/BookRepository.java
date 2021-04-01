package com.tao.querydsl.dao;

import com.tao.querydsl.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * book dao
 *
 * @author Jiantao Yan
 * @title: BookRepository
 * @date 2021/3/27 14:11
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book> {
}
