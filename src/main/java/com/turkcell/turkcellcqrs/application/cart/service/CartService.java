package com.turkcell.turkcellcqrs.application.cart.service;

import com.turkcell.turkcellcqrs.domain.entity.Cart;
import com.turkcell.turkcellcqrs.domain.entity.Student;

public interface CartService
{
    Cart createCartForStudent(Student student);
}
