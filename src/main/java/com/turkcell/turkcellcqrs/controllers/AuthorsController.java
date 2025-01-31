package com.turkcell.turkcellcqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs.application.author.command.create.CreateAuthorCommand;
import com.turkcell.turkcellcqrs.application.author.command.create.CreatedAuthorResponse;
import com.turkcell.turkcellcqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsController extends BaseController {
    public AuthorsController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedAuthorResponse create(@RequestBody CreateAuthorCommand command) {
        return command.execute(pipeline);
    }
}
