package com.turkcell.turkcellcqrs.persistence.cartitem;

import com.turkcell.turkcellcqrs.domain.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
}
