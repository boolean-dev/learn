package com.tao.querydsl.service;

import cn.hutool.core.collection.CollUtil;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tao.querydsl.dao.BookRepository;
import com.tao.querydsl.entity.Book;
import com.tao.querydsl.entity.QAuthor;
import com.tao.querydsl.entity.QBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * book service
 *
 * @author Jiantao Yan
 * @title: BookService
 * @date 2021/3/27 14:13
 */
@Slf4j
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JPAQueryFactory queryFactory;


    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByNameLike(String name) {
        QBook qBook = QBook.book;
        BooleanExpression expression = qBook.name.like("%" + name + "%");
        return CollUtil.newArrayList(bookRepository.findAll(expression));
    }

    public List<Book> findByAuthorName(String authorName) {
        QBook qBook = QBook.book;
        QAuthor qAuthor = QAuthor.author;
        return queryFactory.select(qBook)
                .from(qBook)
                .leftJoin(qAuthor)
                .on(qAuthor.id.eq(qBook.authorId))
                .where(qAuthor.name.like("%" + authorName + "%"))
                .fetch();
    }

}
