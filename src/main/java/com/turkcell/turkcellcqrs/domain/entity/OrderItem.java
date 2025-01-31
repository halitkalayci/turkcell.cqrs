package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name="order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @UuidGenerator
    private UUID id;
    private int quantity;
    private BigDecimal unitPrice;

    @ManyToOne()
    @JoinColumn(name="order_id", nullable = false)
    private Order order;
    @ManyToOne()
    @JoinColumn(name="book_id",nullable = false)
    private Book book;
}
