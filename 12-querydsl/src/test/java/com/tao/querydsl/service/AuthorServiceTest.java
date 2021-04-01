package com.tao.querydsl.service;

import com.tao.querydsl.entity.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@Transactional
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void save() {
        Author author = new Author();
        author.setGender("Man");
        author.setName("李四");
        author.setBirthday(LocalDateTime.now());
        Author result = authorService.save(author);
        assertNotNull(result);
        System.out.println(result);

    }

    @Test
    void findAll() {
        List<Author> authorList = authorService.findAll();
        assertNotNull(authorList);
        authorList.forEach(System.out::println);
    }
}