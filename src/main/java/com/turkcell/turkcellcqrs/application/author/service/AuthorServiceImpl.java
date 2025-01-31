package com.turkcell.turkcellcqrs.application.author.service;

import com.turkcell.turkcellcqrs.domain.entity.Author;
import com.turkcell.turkcellcqrs.persistence.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService
{
    private final AuthorRepository authorRepository;

    @Override
    public Author findById(UUID id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Override
    public UUID delete(UUID id) {
        authorRepository.deleteById(id);
        return id;
    }
}
