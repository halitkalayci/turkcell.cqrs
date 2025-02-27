package com.turkcell.turkcellcqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs.application.book.command.create.CreateBookCommand;
import com.turkcell.turkcellcqrs.application.book.command.create.CreatedBookResponse;
import com.turkcell.turkcellcqrs.application.book.command.update.UpdateBookCommand;
import com.turkcell.turkcellcqrs.application.book.command.update.UpdatedBookResponse;
import com.turkcell.turkcellcqrs.application.book.query.getlist.GetListBookItemDto;
import com.turkcell.turkcellcqrs.application.book.query.getlist.GetListBookQuery;
import com.turkcell.turkcellcqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController extends BaseController
{
    public BooksController(Pipeline pipeline) {
        super(pipeline);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetListBookItemDto> get() {
        GetListBookQuery query = new GetListBookQuery();
        return query.execute(pipeline);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedBookResponse create(@RequestBody CreateBookCommand createBookCommand)
    {
       return createBookCommand.execute(pipeline);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public UpdatedBookResponse update(@RequestBody UpdateBookCommand updateBookCommand)
    {
       return updateBookCommand.execute(pipeline);
    }
}
