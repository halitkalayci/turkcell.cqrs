package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import org.springframework.stereotype.Component;


public class CreateBookCommand implements Command<CreatedBookResponse>
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //@NotBlank


    @Component
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse>
    {
        private final BookRepository bookRepository;

        public CreateBookCommandHandler(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

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