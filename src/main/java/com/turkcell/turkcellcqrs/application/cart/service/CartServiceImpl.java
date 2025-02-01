package com.turkcell.turkcellcqrs.application.cart.service;

import com.turkcell.turkcellcqrs.domain.entity.Cart;
import com.turkcell.turkcellcqrs.domain.entity.Student;
import com.turkcell.turkcellcqrs.persistence.cart.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart createCartForStudent(Student student) {
        // Business Rule -> Aynı student için 2. cart oluşmamalı.
        //throw new RuntimeException("Bir hata..");
        Cart cart = new Cart();
        cart.setStudent(student);
        cartRepository.save(cart);
        return cart;
    }
}
