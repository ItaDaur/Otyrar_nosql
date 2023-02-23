package com.example.otyrar_nosql.service;

import com.example.otyrar_nosql.entity.Book;
import com.example.otyrar_nosql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.insert(book);
    }
}
