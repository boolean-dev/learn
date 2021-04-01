package com.tao.querydsl.dao;

import com.tao.querydsl.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * author dao
 *
 * @author Jiantao Yan
 * @title: AuthRepository
 * @date 2021/3/27 14:11
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, QuerydslPredicateExecutor<Author> {
}
