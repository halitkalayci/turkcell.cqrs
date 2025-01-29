package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.application.book.mapper.BookMapper;
import com.turkcell.turkcellcqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;
import lombok.*;

@Getter
@Setter
public class CreateBookCommand implements Command<CreatedBookResponse>
{
    @NotBlank
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse>
    {
        private final BookRepository bookRepository;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            // Manual Mapping
            // CreateBookCommand -> Book
            //Book book = new Book();
            //book.setName(createBookCommand.getName());
            //
            // Auto Mapping (MapStruct)
            BookMapper mapper = BookMapper.INSTANCE;
            Book book = mapper.convertCreateCommandToBook(createBookCommand);
            bookRepository.save(book);

            return mapper.convertBookToCreateBookResponse(book);
        }
    }
}
// Inner Class - Nested Class
// Bütün command-querylerde auto mapping yapılmalı.
// Validation pipeline sisteme eklenmeli. Controllerda @Valid gereksinimi olmadan tüm command/queryler
// validate edilmeli.
// Behavior sırası?
