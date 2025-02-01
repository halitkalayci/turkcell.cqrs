package com.turkcell.turkcellcqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Table(name="students")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User {
    @Column(name="student_no")
    private String studentNo;
    @OneToOne(mappedBy = "student")
    private Cart cart;
    @OneToMany(mappedBy = "student")
    private Set<Order> orders;
}
// Create Student Command
// İçerisinde, CartService ile bir adet cart oluşturulan bir command yazalım.
// 20:45