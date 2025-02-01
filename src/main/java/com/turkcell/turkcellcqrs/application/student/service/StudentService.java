package com.turkcell.turkcellcqrs.application.student.service;

import com.turkcell.turkcellcqrs.domain.entity.Student;

import java.util.UUID;

public interface StudentService {
    Student findStudentById(UUID id);
}
