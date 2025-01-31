package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @UuidGenerator
    private UUID id;
    private int quantity;

    @ManyToOne()
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;
    @ManyToOne()
    @JoinColumn(name="book_id",nullable = false)
    private Book book;
}
