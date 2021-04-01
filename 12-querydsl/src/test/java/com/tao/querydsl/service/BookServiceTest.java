package com.tao.querydsl.service;

import com.tao.querydsl.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@Transactional
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void save() {
        Book book = new Book();
        book.setAuthorId(2L);
        book.setName("Spring-boot-jpa基础");
        book.setPrice(BigDecimal.valueOf(68.8));
        book.setPublishTime(LocalDateTime.now());

        Book result = bookService.save(book);
        assertNotNull(result);
    }

    @Test
    void findAll() {
        List<Book> bookList = bookService.findAll();
        assertNotNull(bookList);
        bookList.forEach(System.out::println);

    }

    @Test
    void findByNameLike() {
        List<Book> bookList = bookService.findByNameLike("Java");
        assertNotNull(bookList);
        bookList.forEach(System.out::println);
    }

    @Test
    void findByAuthorName() {
        List<Book> bookList = bookService.findByAuthorName("小红");
        assertNotNull(bookList);
        bookList.forEach(System.out::println);
    }

}