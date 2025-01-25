package com.turkcell.turkcellcqrs.application.book.command.create;

import java.util.UUID;


public class CreatedBookResponse
{
    private UUID id;
    private String name;

    public CreatedBookResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public CreatedBookResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
