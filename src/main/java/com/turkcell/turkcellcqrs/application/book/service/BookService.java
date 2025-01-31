package com.turkcell.turkcellcqrs.application.book.service;

import com.turkcell.turkcellcqrs.domain.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    Book findById(UUID id);
    List<Book> findAll();
    Book save(Book book);
    UUID delete(UUID id);
}
