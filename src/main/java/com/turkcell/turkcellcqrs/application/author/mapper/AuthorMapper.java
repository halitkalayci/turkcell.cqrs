package com.turkcell.turkcellcqrs.application.author.mapper;

import com.turkcell.turkcellcqrs.application.author.command.create.CreateAuthorCommand;
import com.turkcell.turkcellcqrs.application.author.command.create.CreatedAuthorResponse;
import com.turkcell.turkcellcqrs.domain.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author createAuthorFromCreateCommand(CreateAuthorCommand createAuthorCommand);
    CreatedAuthorResponse createAuthorResponseFromAuthor(Author author);
}
