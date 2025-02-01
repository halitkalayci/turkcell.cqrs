package com.turkcell.turkcellcqrs.application.cartitem.mapper;

import com.turkcell.turkcellcqrs.application.cartitem.command.create.CreateCartItemCommand;
import com.turkcell.turkcellcqrs.application.cartitem.command.create.CreatedCartItemResponse;
import com.turkcell.turkcellcqrs.domain.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CartItemMapper {
    @Mapping(target = "book.id", source = "bookId")
    public abstract CartItem mapFromCreateCartItemCommand(CreateCartItemCommand createCartItemCommand);

    public abstract CreatedCartItemResponse mapCreatedResponseFromCartItem(CartItem cartItem);
}
