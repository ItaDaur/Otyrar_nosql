package com.example.otyrar_nosql.service;

import com.example.otyrar_nosql.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    void save(Book book);
}
