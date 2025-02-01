package com.turkcell.turkcellcqrs.application.cartitem.command.create;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreatedCartItemResponse
{
    private UUID id;
    private int quantity;
}
