package com.turkcell.turkcellcqrs.persistence.student;

import com.turkcell.turkcellcqrs.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> { }
