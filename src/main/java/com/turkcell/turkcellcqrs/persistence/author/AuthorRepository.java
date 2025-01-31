package com.turkcell.turkcellcqrs.persistence.author;

import com.turkcell.turkcellcqrs.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> { }
