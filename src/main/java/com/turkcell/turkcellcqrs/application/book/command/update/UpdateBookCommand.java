package com.turkcell.turkcellcqrs.application.book.command.update;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class UpdateBookCommand implements Command<UpdatedBookResponse>
{
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Component
    public static class UpdateBookCommandHandler
            implements Command.Handler<UpdateBookCommand, UpdatedBookResponse> {
        private final BookRepository bookRepository;

        public UpdateBookCommandHandler(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @Override
        public UpdatedBookResponse handle(UpdateBookCommand command) {
            Book book = bookRepository
                    .findById(command.getId()).orElseThrow(() -> new RuntimeException("Book not found"));

            book.setName(command.getName());
            bookRepository.save(book);

            return new UpdatedBookResponse(book.getId(), book.getName());
        }
    }
}
