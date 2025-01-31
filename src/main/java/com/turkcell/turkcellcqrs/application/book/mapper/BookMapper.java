package com.turkcell.turkcellcqrs.application.book.mapper;

import com.turkcell.turkcellcqrs.application.book.command.create.CreateBookCommand;
import com.turkcell.turkcellcqrs.application.book.command.create.CreatedBookResponse;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    // Target fonksiyon_ismi(Source s);
    // @Mapping(target = "name",source = "title")
    @Mapping(target="author.id", source="authorId")
    Book convertCreateCommandToBook(CreateBookCommand command);

    CreatedBookResponse convertBookToCreateBookResponse(Book book);
}
