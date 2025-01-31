package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @UuidGenerator
    @Id
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
}
