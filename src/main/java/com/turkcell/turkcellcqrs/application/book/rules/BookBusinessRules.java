package com.turkcell.turkcellcqrs.application.book.rules;

import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BookBusinessRules
{
    private final BookRepository bookRepository;

    public void bookShouldExistWithGivenId(UUID id)
    {
        bookRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void bookShouldNotBeNull(Book book)
    {
        if(book == null)
            throw new RuntimeException("Book cannot be null");
    }
}
