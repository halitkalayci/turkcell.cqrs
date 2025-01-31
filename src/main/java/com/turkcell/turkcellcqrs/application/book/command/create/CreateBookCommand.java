package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.application.author.rules.AuthorBusinessRules;
import com.turkcell.turkcellcqrs.application.author.service.AuthorService;
import com.turkcell.turkcellcqrs.application.book.mapper.BookMapper;
import com.turkcell.turkcellcqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.turkcellcqrs.domain.entity.Author;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class CreateBookCommand implements Command<CreatedBookResponse>
{
    @NotBlank
    private String name;
    private UUID authorId;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse>
    {
        private final BookRepository bookRepository;
        //private final AuthorService authorService;
        private final AuthorBusinessRules authorBusinessRules;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            // iş kuralı?
            //Author author = authorService.findById(createBookCommand.authorId);
            // Genelde business rules diğer entityler ile olan ilişkimizde yeterli olsa da, servis
            // ihtiyaç durumunda entegre edilebilir!
            authorBusinessRules.authorWithIdCanNotBeNull(createBookCommand.authorId);

            BookMapper mapper = BookMapper.INSTANCE;
            Book book = mapper.convertCreateCommandToBook(createBookCommand);
            bookRepository.save(book);

            // BookId
            // orderitemservice -> order id ->

            return mapper.convertBookToCreateBookResponse(book);
        }
    }
}
// Inner Class - Nested Class
// Bütün command-querylerde auto mapping yapılmalı.
// Validation pipeline sisteme eklenmeli. Controllerda @Valid gereksinimi olmadan tüm command/queryler
// validate edilmeli.
// Behavior sırası?
