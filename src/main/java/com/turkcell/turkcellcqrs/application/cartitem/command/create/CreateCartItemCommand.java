package com.turkcell.turkcellcqrs.application.cartitem.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.application.cart.service.CartService;
import com.turkcell.turkcellcqrs.application.cartitem.mapper.CartItemMapper;
import com.turkcell.turkcellcqrs.application.student.service.StudentService;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.domain.entity.Cart;
import com.turkcell.turkcellcqrs.domain.entity.CartItem;
import com.turkcell.turkcellcqrs.domain.entity.Student;
import com.turkcell.turkcellcqrs.persistence.cartitem.CartItemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

// Refactorları yapalım.
// * -> Order feature'ı geliştirmek. -> Sipariş -> Cart -> CartItems'in OrderItems'a transferi -> CartItems'ın silinmesi.
// (Optional) -> JWT implementasyonu yapalım.

// Sipariş oluştuırulurken 5. itemda problem -> 5.
@Getter
@Setter
public class CreateCartItemCommand implements Command<CreatedCartItemResponse>
{
    private UUID bookId;
    private int quantity;

    @Component
    @RequiredArgsConstructor
    public static class CreateCartItemCommandHandler
            implements Command.Handler<CreateCartItemCommand,CreatedCartItemResponse>
    {
        private final CartService cartService;
        private final StudentService studentService;
        private final CartItemRepository cartItemRepository;
        private final CartItemMapper cartItemMapper;

        @Override
        public CreatedCartItemResponse handle(CreateCartItemCommand createCartItemCommand) {
            String studentId = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
            Student student = studentService.findStudentById(UUID.fromString(studentId));
            Cart cart = cartService.getOrCreateCartForStudent(student);

            CartItem cartItem = cart.getCartItems()
                    .stream()
                    .filter((c) -> c.getBook().getId().equals(createCartItemCommand.getBookId()))
                    .findFirst()
                    .orElse(null);

            if(cartItem != null)
            {
                cartItem.setQuantity(cartItem.getQuantity() + createCartItemCommand.getQuantity());
                cartItemRepository.save(cartItem);
            }
            else
            {
                cartItem = cartItemMapper.mapFromCreateCartItemCommand(createCartItemCommand);
                cartItem.setCart(cart);
                cartItemRepository.save(cartItem);
            }

            return cartItemMapper.mapCreatedResponseFromCartItem(cartItem);
        }
    }
}
