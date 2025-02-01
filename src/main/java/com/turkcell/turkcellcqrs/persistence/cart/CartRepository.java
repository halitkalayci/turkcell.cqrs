package com.turkcell.turkcellcqrs.persistence.cart;

import com.turkcell.turkcellcqrs.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
}
