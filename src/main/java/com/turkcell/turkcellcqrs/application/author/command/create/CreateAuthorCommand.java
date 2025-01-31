package com.turkcell.turkcellcqrs.application.author.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.application.author.mapper.AuthorMapper;
import com.turkcell.turkcellcqrs.domain.entity.Author;
import com.turkcell.turkcellcqrs.persistence.author.AuthorRepository;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorCommand implements Command<CreatedAuthorResponse>
{
    private String firstName;
    private String lastName;

    @Component
    @RequiredArgsConstructor
    public static class CreateAuthorCommandHandler
            implements Command.Handler<CreateAuthorCommand, CreatedAuthorResponse>
    {
        private final AuthorRepository authorRepository;
        @Override
        public CreatedAuthorResponse handle(CreateAuthorCommand createAuthorCommand) {
            AuthorMapper authorMapper = AuthorMapper.INSTANCE;
            Author author = authorMapper.createAuthorFromCreateCommand(createAuthorCommand);
            authorRepository.save(author);

            return authorMapper.createAuthorResponseFromAuthor(author);
        }
    }
}
