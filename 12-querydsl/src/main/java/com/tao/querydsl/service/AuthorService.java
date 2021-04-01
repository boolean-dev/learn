package com.tao.querydsl.service;

import com.tao.querydsl.dao.AuthorRepository;
import com.tao.querydsl.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author service
 *
 * @author Jiantao Yan
 * @title: AuthorService
 * @date 2021/3/27 14:13
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
