package com.turkcell.turkcellcqrs.application.author.command.create;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreatedAuthorResponse
{
    private UUID id;
    private String firstName;
    private String lastName;
}
