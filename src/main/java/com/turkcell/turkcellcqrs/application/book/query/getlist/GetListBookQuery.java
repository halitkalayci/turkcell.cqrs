package com.turkcell.turkcellcqrs.application.book.query.getlist;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class GetListBookQuery implements Command<List<GetListBookItemDto>>
{
    @Component
    @RequiredArgsConstructor
    public static class GetListBookQueryHandler
            implements Command.Handler<GetListBookQuery, List<GetListBookItemDto>>
    {
        private final BookRepository bookRepository;

        @Override
        public List<GetListBookItemDto> handle(GetListBookQuery getListBookQuery) {
            List<Book> books = bookRepository.findAll();

            List<GetListBookItemDto> bookDtos = books
                    .stream()
                    .map(book -> new GetListBookItemDto(book.getId(), book.getName()))
                    .toList();

            return bookDtos;
        }
    }
}
