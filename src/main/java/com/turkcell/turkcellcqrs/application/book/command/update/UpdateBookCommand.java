package com.turkcell.turkcellcqrs.application.book.command.update;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
public class UpdateBookCommand implements Command<UpdatedBookResponse>
{
    private UUID id;
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class UpdateBookCommandHandler
            implements Command.Handler<UpdateBookCommand, UpdatedBookResponse> {
        private final BookRepository bookRepository;

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
