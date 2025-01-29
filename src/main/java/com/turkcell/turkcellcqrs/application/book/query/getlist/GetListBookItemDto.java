package com.turkcell.turkcellcqrs.application.book.query.getlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListBookItemDto
{
    private UUID id;
    private String name;
}
