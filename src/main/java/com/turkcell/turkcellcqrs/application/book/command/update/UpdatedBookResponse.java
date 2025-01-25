package com.turkcell.turkcellcqrs.application.book.command.update;

import java.util.UUID;

public class UpdatedBookResponse
{
    private UUID id;
    private String name;

    public UpdatedBookResponse() {
    }

    public UpdatedBookResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
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
