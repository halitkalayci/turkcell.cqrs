package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @UuidGenerator
    @Id
    private UUID id;

    private String email;

    private String password;
}
