package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import org.springframework.stereotype.Component;
import lombok.*;

@Getter
@Setter
public class CreateBookCommand implements Command<CreatedBookResponse>
{
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse>
    {
        private final BookRepository bookRepository;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            Book book = new Book();
            book.setName(createBookCommand.getName());
            bookRepository.save(book);

            return new CreatedBookResponse(book.getId(), book.getName());
        }
    }
}
// Inner Class - Nested Class