package com.turkcell.turkcellcqrs.application.book.command.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedBookResponse
{
    private UUID id;
    private String name;
}
