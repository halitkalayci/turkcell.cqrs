package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;

public class CreateBookCommand implements Command<CreatedBookResponse>
{
    //@NotBlank
    private String name;


    public static class CreateBookCommandHandler {

    }
}
