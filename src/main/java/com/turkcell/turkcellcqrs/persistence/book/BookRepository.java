package com.turkcell.turkcellcqrs.persistence.book;

import com.turkcell.turkcellcqrs.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> { }
