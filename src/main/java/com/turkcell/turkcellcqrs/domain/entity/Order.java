package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne()
    @JoinColumn(name="student_id", unique = true)
    private Student student;

    @Column(name="order_date")
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;
}
