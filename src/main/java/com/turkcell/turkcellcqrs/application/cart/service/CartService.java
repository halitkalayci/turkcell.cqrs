package com.turkcell.turkcellcqrs.application.cart.service;

import com.turkcell.turkcellcqrs.domain.entity.Cart;
import com.turkcell.turkcellcqrs.domain.entity.Student;

import java.util.UUID;

public interface CartService
{
    Cart createCartForStudent(Student student);
    Cart getOrCreateCartForStudent(Student student);
}
