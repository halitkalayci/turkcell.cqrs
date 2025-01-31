package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart
{
    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne()
    @JoinColumn(name="student_id", unique = true)
    private Student student;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;
}
